package com.bank.application;



import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Transaccion;
import com.bank.domain.ports.CuentaRepository;
import com.bank.domain.ports.TransaccionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransaccionServiceTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @Mock
    private CuentaRepository cuentaRepository;

    private TransaccionService transaccionService;

    @BeforeEach
    void setUp() {
        transaccionService = new TransaccionService(transaccionRepository, cuentaRepository);
    }

    @Test
    void registrarTransaccion_deberiaCrearTransaccionEntreCuentas() throws Exception {
        // Given
        UUID cuentaOrigenId = UUID.randomUUID();
        UUID cuentaDestinoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("1000.00");
        String tipo = "TRANSFERENCIA";

        Cliente clienteOrigen = new Cliente(
                "Pedro",
                "Gomez",
                "pedro@example.com",
                LocalDate.of(1990, 1, 1),
                "11111111",
                Cliente.TipoIdentificacion.CEDULA
        );
        Cliente clienteDestino = new Cliente(
                "Laura",
                "Fernandez",
                "laura@example.com",
                LocalDate.of(1992, 2, 2),
                "22222222",
                Cliente.TipoIdentificacion.CEDULA
        );

        CuentaAhorro cuentaOrigen = new CuentaAhorro(
                "ACC-100",
                clienteOrigen,
                new BigDecimal("5000.00"),
                new BigDecimal("0.05")
        );
        CuentaAhorro cuentaDestino = new CuentaAhorro(
                "ACC-200",
                clienteDestino,
                new BigDecimal("2000.00"),
                new BigDecimal("0.05")
        );

        when(cuentaRepository.buscarPorId(cuentaOrigenId))
                .thenReturn(Optional.of(cuentaOrigen));
        when(cuentaRepository.buscarPorId(cuentaDestinoId))
                .thenReturn(Optional.of(cuentaDestino));
        when(transaccionRepository.guardar(any(Transaccion.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Transaccion resultado = transaccionService.registrarTransaccion(
                cuentaOrigenId, cuentaDestinoId, monto, tipo
        );

        // Then
        assertNotNull(resultado);
        assertEquals(monto, resultado.getMonto());
        verify(transaccionRepository, times(1)).guardar(any(Transaccion.class));
    }

    @Test
    void obtenerTransaccionesPorCuenta_deberiaRetornarListaDeTransacciones() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Roberto",
                "Sanchez",
                "roberto@example.com",
                LocalDate.of(1985, 5, 15),
                "33333333",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-300",
                cliente,
                new BigDecimal("10000.00"),
                new BigDecimal("0.04")
        );

        Transaccion transaccion1 = new Transaccion(
                cuenta, null, new BigDecimal("500.00"), Transaccion.Tipo.DEPOSITO
        );
        Transaccion transaccion2 = new Transaccion(
                null, cuenta, new BigDecimal("300.00"), Transaccion.Tipo.RETIRO
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(transaccionRepository.buscarPorCuenta(cuentaId))
                .thenReturn(List.of(transaccion1, transaccion2));

        // When
        List<Transaccion> resultados = transaccionService.obtenerTransaccionesPorCuenta(cuentaId);

        // Then
        assertEquals(2, resultados.size());
    }

    @Test
    void realizarDeposito_deberiaCrearTransaccionYActualizarSaldo() throws Exception {
        // Given
        UUID cuentaId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("2000.00");

        Cliente cliente = new Cliente(
                "Sofia",
                "Ramirez",
                "sofia@example.com",
                LocalDate.of(1993, 7, 20),
                "44444444",
                Cliente.TipoIdentificacion.PASAPORTE
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-400",
                cliente,
                new BigDecimal("1000.00"),
                new BigDecimal("0.03")
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(transaccionRepository.guardar(any(Transaccion.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Transaccion resultado = transaccionService.realizarDeposito(cuentaId, monto);

        // Then
        assertNotNull(resultado);
        assertEquals(Transaccion.Tipo.DEPOSITO, resultado.getTipo());
        assertEquals(monto, resultado.getMonto());
    }

    @Test
    void realizarRetiro_deberiaLanzarExcepcionCuandoSaldoInsuficiente() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");

        Cliente cliente = new Cliente(
                "Miguel",
                "Torres",
                "miguel@example.com",
                LocalDate.of(1980, 10, 10),
                "55555555",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-500",
                cliente,
                new BigDecimal("500.00"),
                new BigDecimal("0.02")
        );

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));

        // When / Then
        assertThrows(CuentaBancaria.SaldoInsuficienteException.class, () -> {
            transaccionService.realizarRetiro(cuentaId, monto);
        });
    }

    @Test
    void obtenerTransaccionPorId_deberiaRetornarTransaccionCuandoExiste() {
        // Given
        UUID transaccionId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Elena",
                "Vargas",
                "elena@example.com",
                LocalDate.of(1987, 3, 25),
                "66666666",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-600",
                cliente,
                new BigDecimal("8000.00"),
                new BigDecimal("0.04")
        );
        Transaccion transaccionEsperada = new Transaccion(
                cuenta, null, new BigDecimal("1500.00"), Transaccion.Tipo.DEPOSITO
        );

        when(transaccionRepository.buscarPorId(transaccionId))
                .thenReturn(Optional.of(transaccionEsperada));

        // When
        Optional<Transaccion> resultado = transaccionService.obtenerTransaccionPorId(transaccionId);

        // Then
        assertTrue(resultado.isPresent());
        assertEquals(transaccionEsperada.getId(), resultado.get().getId());
    }
}