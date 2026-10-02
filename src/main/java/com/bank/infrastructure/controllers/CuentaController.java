package com.bank.infrastructure.controllers;


import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.application.CuentaService;
import com.bank.domain.model.CuentaBancaria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponse> obtenerCuenta(@PathVariable UUID id) {
        return cuentaService.buscarPorId(id)
            .map(cuenta -> ResponseEntity.ok(mapToResponse(cuenta)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> obtenerPorNumero(@PathVariable String numeroCuenta) {
        return cuentaService.buscarPorNumero(numeroCuenta)
            .map(cuenta -> ResponseEntity.ok(mapToResponse(cuenta)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponse>> listarCuentas() {
        List<CuentaResponse> cuentas = cuentaService.listarTodas()
            .stream()
            .map(this::mapToResponse)
            .toList();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<CuentaResponse>> listarCuentasPorCliente(@PathVariable UUID clienteId) {
        List<CuentaResponse> cuentas = cuentaService.buscarPorCliente(clienteId)
            .stream()
            .map(this::mapToResponse)
            .toList();
        return ResponseEntity.ok(cuentas);
    }

    @PostMapping("/deposito")
    public ResponseEntity<CuentaResponse> realizarDeposito(@RequestBody DepositoRequest request) {
        try {
            CuentaBancaria cuenta = cuentaService.realizarDeposito(
                request.numeroCuenta(),
                request.monto()
            );
            return ResponseEntity.ok(mapToResponse(cuenta));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/retiro")
    public ResponseEntity<CuentaResponse> realizarRetiro(@RequestBody RetiroRequest request) {
        try {
            CuentaBancaria cuenta = cuentaService.realizarRetiro(
                request.numeroCuenta(),
                request.monto()
            );
            return ResponseEntity.ok(mapToResponse(cuenta));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponse> realizarTransferencia(@RequestBody TransferenciaRequest request) {
        try {
            cuentaService.realizarTransferencia(
                request.numeroCuentaOrigen(),
                request.numeroCuentaDestino(),
                request.monto()
            );
            return ResponseEntity.ok(new TransferenciaResponse(
                "Transferencia realizada exitosamente",
                true
            ));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED)
                .body(new TransferenciaResponse("Saldo insuficiente", false));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(new TransferenciaResponse("Datos inválidos", false));
        }
    }

    private CuentaResponse mapToResponse(CuentaBancaria cuenta) {
        return new CuentaResponse(
            cuenta.getId().toString(),
            cuenta.getNumeroCuenta(),
            cuenta.getSaldo(),
            cuenta.getFechaCreacion().toString(),
            cuenta.getCliente().getNombreCompleto()
        );
    }

    public record CuentaResponse(
        String id,
        String numeroCuenta,
        BigDecimal saldo,
        String fechaCreacion,
        String nombreCliente
    ) {}

    public record DepositoRequest(
        String numeroCuenta,
        BigDecimal monto
    ) {}

    public record RetiroRequest(
        String numeroCuenta,
        BigDecimal monto
    ) {}

    public record TransferenciaRequest(
        String numeroCuentaOrigen,
        String numeroCuentaDestino,
        BigDecimal monto
    ) {}

    public record TransferenciaResponse(
        String mensaje,
        boolean exitosa
    ) {}
}