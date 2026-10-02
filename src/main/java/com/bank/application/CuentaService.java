package com.bank.application;

import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.CuentaBancaria.SaldoInsuficienteException;
import com.bank.domain.ports.CuentaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public CuentaBancaria crearCuentaAhorro(Cliente cliente, BigDecimal saldoInicial, BigDecimal tasaInteres) {
        validarCliente(cliente);
        validarMontoPositivo(saldoInicial, "Saldo inicial");
        validarTasaInteres(tasaInteres);
        
        String numeroCuenta = generarNumeroCuenta();
        CuentaAhorro cuenta = new CuentaAhorro(numeroCuenta, cliente, saldoInicial, tasaInteres);
        return cuentaRepository.save(cuenta);
    }

    public Optional<CuentaBancaria> buscarPorId(UUID id) {
        return cuentaRepository.findById(id);
    }

    public List<CuentaBancaria> listarTodas() {
        return cuentaRepository.findAll();
    }

    public List<CuentaBancaria> buscarPorCliente(UUID clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public void depositar(UUID cuentaId, BigDecimal monto) {
        validarMontoPositivo(monto, "Monto a depositar");
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.depositar(monto);
        cuentaRepository.save(cuenta);
    }

    public void retirar(UUID cuentaId, BigDecimal monto) throws SaldoInsuficienteException {
        validarMontoPositivo(monto, "Monto a retirar");
        
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        
        cuenta.retirar(monto);
        cuentaRepository.save(cuenta);
    }

    public void transferir(UUID cuentaOrigenId, UUID cuentaDestinoId, BigDecimal monto) 
            throws SaldoInsuficienteException {
        validarMontoPositivo(monto, "Monto a transferir");
        
        CuentaBancaria cuentaOrigen = cuentaRepository.findById(cuentaOrigenId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada: " + cuentaOrigenId));
        
        CuentaBancaria cuentaDestino = cuentaRepository.findById(cuentaDestinoId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta destino no encontrada: " + cuentaDestinoId));
        
        cuentaOrigen.transferir(cuentaDestino, monto);
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
    }

    public BigDecimal consultarSaldo(UUID cuentaId) {
        CuentaBancaria cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + cuentaId));
        return cuenta.getSaldo();
    }

    public void eliminarCuenta(UUID cuentaId) {
        if (!cuentaRepository.existsById(cuentaId)) {
            throw new IllegalArgumentException("Cuenta no encontrada: " + cuentaId);
        }
        cuentaRepository.deleteById(cuentaId);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (!cliente.esMayorDeEdad()) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad para crear una cuenta");
        }
    }

    private void validarMontoPositivo(BigDecimal monto, String concepto) {
        if (monto == null) {
            throw new IllegalArgumentException(concepto + " no puede ser nulo");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(concepto + " debe ser mayor a cero");
        }
    }

    private void validarTasaInteres(BigDecimal tasaInteres) {
        if (tasaInteres == null) {
            throw new IllegalArgumentException("La tasa de interés no puede ser nula");
        }
        if (tasaInteres.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        if (tasaInteres.compareTo(new BigDecimal("1.00")) > 0) {
            throw new IllegalArgumentException("La tasa de interés no puede exceder el 100%");
        }
    }

    private String generarNumeroCuenta() {
        return "CA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}