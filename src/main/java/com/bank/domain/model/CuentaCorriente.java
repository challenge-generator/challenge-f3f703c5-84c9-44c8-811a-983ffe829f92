package com.bank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CuentaCorriente es una implementación concreta de CuentaBancaria.
 * Este tipo de cuenta permite sobregiro ( overdraft ) y tiene comisiones por uso.
 * Representa la aplicación de herencia y polimorfismo en el dominio bancario.
 */
public class CuentaCorriente extends CuentaBancaria {

    private BigDecimal limiteSobregiro;
    private BigDecimal comisionMensual;
    private BigDecimal saldoSobregiroUtilizado;
    private boolean activa;

    public CuentaCorriente(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial,
                           BigDecimal limiteSobregiro, BigDecimal comisionMensual) {
        super(numeroCuenta, cliente, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
        this.comisionMensual = comisionMensual;
        this.saldoSobregiroUtilizado = BigDecimal.ZERO;
        this.activa = true;
    }

    @Override
    public void depositar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
        }

        // Primero compensamos el sobregiro utilizado si existe
        if (saldoSobregiroUtilizado.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal montoParaSobregiro = monto.min(saldoSobregiroUtilizado);
            saldoSobregiroUtilizado = saldoSobregiroUtilizado.subtract(montoParaSobregiro);
            monto = monto.subtract(montoParaSobregiro);
        }

        // El resto se deposita al saldo
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal nuevoSaldo = getSaldo().add(monto);
            actualizarSaldo(nuevoSaldo);
        }
    }

    @Override
    public void retirar(BigDecimal monto) throws SaldoInsuficienteException {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero");
        }

        BigDecimal saldoDisponible = getSaldo().add(limiteSobregiro).subtract(saldoSobregiroUtilizado);

        if (monto.compareTo(saldoDisponible) > 0) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente. Disponible: " + saldoDisponible + ", Solicitado: " + monto
            );
        }

        BigDecimal nuevoSaldo = getSaldo().subtract(monto);

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            // Usamos sobregiro
            saldoSobregiroUtilizado = saldoSobregiroUtilizado.add(nuevoSaldo.abs());
            actualizarSaldo(BigDecimal.ZERO);
        } else {
            actualizarSaldo(nuevoSaldo);
        }
    }

    /**
     * Aplica la comisión mensual a la cuenta corriente.
     * Este método demuestra polimorfismo: cada tipo de cuenta implementa su propia lógica.
     */
    public void aplicarComisionMensual() {
        if (!activa) {
            return;
        }
        try {
            retirar(comisionMensual);
        } catch (SaldoInsuficienteException e) {
            // Si no hay saldo suficiente, se acumula como deuda
            BigDecimal nuevoSaldo = getSaldo().subtract(comisionMensual);
            actualizarSaldo(nuevoSaldo);
        }
    }

    /**
     * Calcula el interés aplicable al sobregiro utilizado.
     * Las cuentas corrientes cobran intereses por el uso del sobregiro.
     */
    public BigDecimal calcularInteresSobregiro(BigDecimal tasaAnual) {
        if (saldoSobregiroUtilizado.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        // Interés proporcional al tiempo (mensual)
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(12), 6, java.math.RoundingMode.HALF_UP);
        return saldoSobregiroUtilizado.multiply(tasaMensual);
    }

    /**
     * Consulta el saldo disponible considerando el límite de sobregiro.
     */
    public BigDecimal getSaldoDisponible() {
        return getSaldo().add(limiteSobregiro).subtract(saldoSobregiroUtilizado);
    }

    /**
     * Consulta cuánto del límite de sobregiro está disponible.
     */
    public BigDecimal getSobregiroDisponible() {
        return limiteSobregiro.subtract(saldoSobregiroUtilizado);
    }

    public BigDecimal getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public BigDecimal getComisionMensual() {
        return comisionMensual;
    }

    public BigDecimal getSaldoSobregiroUtilizado() {
        return saldoSobregiroUtilizado;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    private void actualizarSaldo(BigDecimal nuevoSaldo) {
        try {
            var saldoField = CuentaBancaria.class.getDeclaredField("saldo");
            saldoField.setAccessible(true);
            saldoField.set(this, nuevoSaldo);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar saldo", e);
        }
    }
}