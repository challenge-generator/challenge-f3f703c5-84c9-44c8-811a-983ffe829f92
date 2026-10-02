package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
public abstract class CuentaBancaria {
    private UUID id;

    @NotNull(message = "El número de cuenta no puede ser nulo")
    private String numeroCuenta;

    @NotNull(message = "El cliente asociado no puede ser nulo")
    private Cliente cliente;

    @NotNull(message = "El saldo no puede ser nulo")
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private BigDecimal saldo;

    @NotNull(message = "La fecha de creación no puede ser nula")
    private LocalDateTime fechaCreacion;

    public CuentaBancaria(String numeroCuenta, Cliente cliente, BigDecimal saldoInicial) {
        this.id = UUID.randomUUID();
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldoInicial != null ? saldoInicial : BigDecimal.ZERO;
        this.fechaCreacion = LocalDateTime.now();
    }

    public abstract void depositar(BigDecimal monto);

    public abstract void retirar(BigDecimal monto) throws SaldoInsuficienteException;

    public void transferir(CuentaBancaria destino, BigDecimal monto) throws SaldoInsuficienteException {
        if (this.equals(destino)) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }
        this.retirar(monto);
        destino.depositar(monto);
    }

    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }
}