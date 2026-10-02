package com.bank.application;

import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.CuentaBancaria.SaldoInsuficienteException;
import com.bank.domain.model.Transaccion;
import com.bank.domain.ports.CuentaRepository;
import com.bank.domain.ports.TransaccionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Transaccion realizarDeposito(UUID cuentaId, BigDecimal monto) {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaId);
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.depositar(monto);
        cuentaRepository.save(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaId,
            null,
            monto,
            Transaccion.Tipo.DEPOSITO,
            LocalDateTime.now(),
            "Depósito realizado exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarRetiro(UUID cuentaId, BigDecimal monto) throws SaldoInsuficienteException {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaId);
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.retirar(monto);
        cuentaRepository.save(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaId,
            null,
            monto.negate(),
            Transaccion.Tipo.RETIRO,
            LocalDateTime.now(),
            "Retiro realizado exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarTransferencia(UUID cuentaOrigenId, UUID cuentaDestinoId, BigDecimal monto) 
            throws SaldoInsuficienteException {
        validarMontoPositivo(monto);
        validarCuentaExistente(cuentaOrigenId);
        validarCuentaExistente(cuentaDestinoId);
        
        if (cuentaOrigenId.equals(cuentaDestinoId)) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }
        
        CuentaBancaria cuentaOrigen = cuentaRepository.findById(cuentaOrigenId).get();
        CuentaBancaria cuentaDestino = cuentaRepository.findById(cuentaDestinoId).get();
        
        cuentaOrigen.transferir(cuentaDestino, monto);
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID(),
            cuentaOrigenId,
            cuentaDestinoId,
            monto.negate(),
            Transaccion.Tipo.TRANSFERENCIA,
            LocalDateTime.now(),
            "Transferencia realizada exitosamente"
        );
        
        return transaccionRepository.save(transaccion);
    }

    public Optional<Transaccion> buscarPorId(UUID id) {
        return transaccionRepository.findById(id);
    }

    public List<Transaccion> listarTodas() {
        return transaccionRepository.findAll();
    }

    public List<Transaccion> buscarPorCuenta(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaId(cuentaId);
    }

    public List<Transaccion> buscarHistorialOrigen(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaOrigenId(cuentaId);
    }

    public List<Transaccion> buscarHistorialDestino(UUID cuentaId) {
        validarCuentaExistente(cuentaId);
        return transaccionRepository.findByCuentaDestinoId(cuentaId);
    }

    public void eliminarTransaccion(UUID id) {
        if (!transaccionRepository.existsById(id)) {
            throw new IllegalArgumentException("Transacción no encontrada: " + id);
        }
        transaccionRepository.deleteById(id);
    }

    public BigDecimal calcularTotalMovimientos(UUID cuentaId, Transaccion.Tipo tipo) {
        List<Transaccion> transacciones = transaccionRepository.findByCuentaId(cuentaId);
        return transacciones.stream()
            .filter(t -> t.getTipo() == tipo)
            .map(Transaccion::getMonto)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularDepositosTotales(UUID cuentaId) {
        return calcularTotalMovimientos(cuentaId, Transaccion.Tipo.DEPOSITO);
    }

    public BigDecimal calcularRetirosTotales(UUID cuentaId) {
        return calcularTotalMovimientos(cuentaId, Transaccion.Tipo.RETIRO).abs();
    }

    private void validarMontoPositivo(BigDecimal monto) {
        if (monto == null) {
            throw new IllegalArgumentException("El monto no puede ser nulo");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
    }

    private void validarCuentaExistente(UUID cuentaId) {
        if (!cuentaRepository.existsById(cuentaId)) {
            throw new IllegalArgumentException("La cuenta no existe: " + cuentaId);
        }
    }
}