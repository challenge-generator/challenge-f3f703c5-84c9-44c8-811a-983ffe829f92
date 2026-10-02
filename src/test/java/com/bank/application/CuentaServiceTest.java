package com.bank.application;



import com.bank.domain.model.SaldoInsuficienteException;
import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.Cliente;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.ports.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    private CuentaService cuentaService;

    @BeforeEach
    void setUp() {
        cuentaService = new CuentaService(cuentaRepository);
    }

    @Test
    void crearCuentaAhorro_deberiaCrearCuentaConDatosValidos() {
        // Given
        Cliente cliente = new Cliente(
                "Juan",
                "Perez",
                "juan@example.com",
                LocalDate.of(1990, 5, 15),
                "12345678",
                Cliente.TipoIdentificacion.CEDULA
        );
        BigDecimal saldoInicial = new BigDecimal("1000.00");
        BigDecimal tasaInteres = new BigDecimal("0.05");

        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        CuentaAhorro cuenta = cuentaService.crearCuentaAhorro(
                cliente, saldoInicial, tasaInteres
        );

        // Then
        assertNotNull(cuenta);
        assertEquals(saldoInicial, cuenta.getSaldo());
        verify(cuentaRepository, times(1)).guardar(any(CuentaBancaria.class));
    }

    @Test
    void obtenerCuentaPorId_deberiaRetornarCuentaCuandoExiste() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Maria",
                "Garcia",
                "maria@example.com",
                LocalDate.of(1985, 3, 20),
                "87654321",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuentaEsperada = new CuentaAhorro(
                "ACC-001",
                cliente,
                new BigDecimal("5000.00"),
                new BigDecimal("0.04")
        );

        when(cuentaRepository.buscarPorId(cuentaId))
                .thenReturn(Optional.of(cuentaEsperada));

        // When
        Optional<CuentaBancaria> resultado = cuentaService.obtenerCuentaPorId(cuentaId);

        // Then
        assertTrue(resultado.isPresent());
        assertEquals(cuentaEsperada.getId(), resultado.get().getId());
    }

    @Test
    void obtenerCuentaPorId_deberiaRetornarVacioCuandoNoExiste() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        when(cuentaRepository.buscarPorId(cuentaId))
                .thenReturn(Optional.empty());

        // When
        Optional<CuentaBancaria> resultado = cuentaService.obtenerCuentaPorId(cuentaId);

        // Then
        assertTrue(resultado.isEmpty());
    }

    @Test
    void depositar_deberiaIncrementarSaldoDeCuenta() throws Exception {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Carlos",
                "Lopez",
                "carlos@example.com",
                LocalDate.of(1992, 8, 10),
                "11223344",
                Cliente.TipoIdentificacion.PASAPORTE
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-002",
                cliente,
                new BigDecimal("1000.00"),
                new BigDecimal("0.03")
        );
        BigDecimal montoDeposito = new BigDecimal("500.00");

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.guardar(any(CuentaBancaria.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        CuentaBancaria resultado = cuentaService.depositar(cuentaId, montoDeposito);

        // Then
        assertEquals(new BigDecimal("1500.00"), resultado.getSaldo());
        verify(cuentaRepository, times(1)).guardar(any(CuentaBancaria.class));
    }

    @Test
    void retirar_deberiaLanzarExcepcionCuandoSaldoInsuficiente() {
        // Given
        UUID cuentaId = UUID.randomUUID();
        Cliente cliente = new Cliente(
                "Ana",
                "Martinez",
                "ana@example.com",
                LocalDate.of(1988, 12, 5),
                "55667788",
                Cliente.TipoIdentificacion.CEDULA
        );
        CuentaAhorro cuenta = new CuentaAhorro(
                "ACC-003",
                cliente,
                new BigDecimal("100.00"),
                new BigDecimal("0.02")
        );
        BigDecimal montoRetiro = new BigDecimal("500.00");

        when(cuentaRepository.buscarPorId(cuentaId)).thenReturn(Optional.of(cuenta));

        // When / Then
        assertThrows(CuentaBancaria.SaldoInsuficienteException.class, () -> {
            cuentaService.retirar(cuentaId, montoRetiro);
        });
    }
}