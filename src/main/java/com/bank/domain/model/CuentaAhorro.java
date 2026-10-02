package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class CuentaAhorro extends CuentaBancaria {
    private BigDecimal tasaInteres;

    public CuentaAhorro(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial, BigDecimal tasaInteres) {
        super(numeroCuenta, cliente, saldoInicial);
        this.tasaInteres = tasaInteres != null ? tasaInteres : BigDecimal.ZERO;
    }

    @Override
    public void depositar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.setSaldo(this.getSaldo().add(monto));
    }

    @Override
    public void retirar(BigDecimal monto) throws SaldoInsuficienteException {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.getSaldo().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        }
        this.setSaldo(this.getSaldo().subtract(monto));
    }

    public void aplicarInteres() {
        BigDecimal interes = this.getSaldo().multiply(tasaInteres)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        this.depositar(interes);
    }

    public BigDecimal calcularInteresMensual() {
        return this.getSaldo().multiply(tasaInteres)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}