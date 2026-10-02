package com.bank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Transaccion representa una operación bancaria en el sistema.
 * Encapsula toda la información relacionada con movimientos financieros,
 * aplicando el principio de encapsulamiento para proteger la integridad de los datos.
 */
public class Transaccion {

    private final UUID id;
    private final String numeroCuentaOrigen;
    private final String numeroCuentaDestino;
    private final BigDecimal monto;
    private final TipoTransaccion tipo;
    private final LocalDateTime fecha;
    private final String descripcion;
    private EstadoTransaccion estado;
    private String referencia;

    public enum TipoTransaccion {
        DEPOSITO,
        RETIRO,
        TRANSFERENCIA,
        PAGO_SERVICIO,
        COMISION,
        INTERES
    }

    public enum EstadoTransaccion {
        PENDIENTE,
        COMPLETADA,
        FALLIDA,
        CANCELADA
    }

    public Transaccion(String numeroCuentaOrigen, String numeroCuentaDestino,
                      BigDecimal monto, TipoTransaccion tipo, String descripcion) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de transacción es obligatorio");
        }

        this.id = UUID.randomUUID();
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.referencia = generarReferencia();
    }

    private String generarReferencia() {
        return String.format("TXN-%s-%s",
            fecha.toString().replace("-", "").replace(":", ""),
            id.toString().substring(0, 8).toUpperCase()
        );
    }

    /**
     * Completa la transacción cambiando su estado a COMPLETADA.
     * Este método aplica el principio de encapsulamiento al controlar
     * las transiciones de estado válidas.
     */
    public void completar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden completar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.COMPLETADA;
    }

    /**
     * Marca la transacción como fallida con un motivo.
     */
    public void fallar(String motivo) {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden fallar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.FALLIDA;
        this.descripcion = descripcion + " | Fallo: " + motivo;
    }

    /**
     * Cancela la transacción si aún está pendiente.
     */
    public void cancelar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException(
                "Solo se pueden cancelar transacciones en estado PENDIENTE"
            );
        }
        this.estado = EstadoTransaccion.CANCELADA;
    }

    /**
     * Verifica si la transacción es de ingreso (a favor del cliente).
     */
    public boolean isIngreso() {
        return tipo == TipoTransaccion.DEPOSITO ||
               tipo == TipoTransaccion.TRANSFERENCIA && numeroCuentaDestino != null;
    }

    /**
     * Verifica si la transacción es de egreso (en contra del cliente).
     */
    public boolean isEgreso() {
        return tipo == TipoTransaccion.RETIRO ||
               tipo == TipoTransaccion.PAGO_SERVICIO ||
               tipo == TipoTransaccion.COMISION;
    }

    /**
     * Verifica si la transacción es una transferencia entre cuentas.
     */
    public boolean isTransferencia() {
        return tipo == TipoTransaccion.TRANSFERENCIA;
    }

    public UUID getId() {
        return id;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        return String.format("Transaccion{referencia=%s, tipo=%s, monto=%s, estado=%s, fecha=%s}",
            referencia, tipo, monto, estado, fecha);
    }
}