package com.bank.infrastructure.controllers;


import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.application.TransaccionService;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Transaccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping
    public ResponseEntity<TransaccionResponse> registrarTransaccion(
            @Valid @RequestBody TransaccionRequest request) {
        Transaccion transaccion = transaccionService.registrarTransaccion(
                request.cuentaOrigenId(),
                request.cuentaDestinoId(),
                request.monto(),
                request.tipo()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TransaccionResponse.from(transaccion));
    }

    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<TransaccionResponse>> obtenerTransaccionesPorCuenta(
            @PathVariable @NotNull UUID cuentaId) {
        List<Transaccion> transacciones = transaccionService.obtenerTransaccionesPorCuenta(cuentaId);
        List<TransaccionResponse> response = transacciones.stream()
                .map(TransaccionResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionResponse> obtenerTransaccionPorId(@PathVariable UUID id) {
        return transaccionService.obtenerTransaccionPorId(id)
                .map(transaccion -> ResponseEntity.ok(TransaccionResponse.from(transaccion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/deposito")
    public ResponseEntity<TransaccionResponse> realizarDeposito(
            @Valid @RequestBody DepositoRequest request) {
        Transaccion transaccion = transaccionService.realizarDeposito(
                request.cuentaId(),
                request.monto()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TransaccionResponse.from(transaccion));
    }

    @PostMapping("/retiro")
    public ResponseEntity<TransaccionResponse> realizarRetiro(
            @Valid @RequestBody RetiroRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarRetiro(
                    request.cuentaId(),
                    request.monto()
            );
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(TransaccionResponse.from(transaccion));
        } catch (CuentaBancaria.SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public record TransaccionRequest(
            @NotNull UUID cuentaOrigenId,
            UUID cuentaDestinoId,
            @NotNull BigDecimal monto,
            @NotNull String tipo
    ) {}

    public record DepositoRequest(
            @NotNull UUID cuentaId,
            @NotNull BigDecimal monto
    ) {}

    public record RetiroRequest(
            @NotNull UUID cuentaId,
            @NotNull BigDecimal monto
    ) {}

    public record TransaccionResponse(
            UUID id,
            UUID cuentaOrigenId,
            UUID cuentaDestinoId,
            BigDecimal monto,
            String tipo,
            String estado,
            String fecha
    ) {
        public static TransaccionResponse from(Transaccion transaccion) {
            return new TransaccionResponse(
                    transaccion.getId(),
                    transaccion.getCuentaOrigen() != null ? transaccion.getCuentaOrigen().getId() : null,
                    transaccion.getCuentaDestino() != null ? transaccion.getCuentaDestino().getId() : null,
                    transaccion.getMonto(),
                    transaccion.getTipo().name(),
                    transaccion.getEstado().name(),
                    transaccion.getFecha().toString()
            );
        }
    }
}