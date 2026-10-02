package com.bank.domain.ports;

import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto que define el contrato de persistencia para cuentas bancarias.
 * Esta interfaz vive en la capa de dominio ("puente") y es implementada
 * por la capa de infraestructura ("adaptador"), aplicando el patrón Ports & Adapters.
 * 
 * El dominio define QUÉ se necesita hacer (abstracción) sin conocer
 * CÓMO se hace (implementación concreta).
 */
public interface CuentaRepository {

    /**
     * Busca una cuenta por su identificador único.
     * @param id el UUID de la cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<CuentaBancaria> findById(UUID id);

    /**
     * Busca una cuenta por su número de cuenta.
     * @param numeroCuenta el número identificador de la cuenta
     * @return Optional con la cuenta si existe, vacío si no
     */
    Optional<CuentaBancaria> findByNumeroCuenta(String numeroCuenta);

    /**
     * Busca todas las cuentas asociadas a un cliente.
     * @param cliente el cliente propietario de las cuentas
     * @return lista de cuentas del cliente
     */
    List<CuentaBancaria> findByCliente(Cliente cliente);

    /**
     * Busca todas las cuentas de un tipo específico.
     * @param tipoCuenta la clase que representa el tipo de cuenta
     * @return lista de cuentas del tipo especificado
     */
    <T extends CuentaBancaria> List<T> findByType(Class<T> tipoCuenta);

    /**
     * Persiste una cuenta en el repositorio.
     * @param cuenta la cuenta a guardar
     * @return la cuenta persistida con su ID asignado
     */
    CuentaBancaria save(CuentaBancaria cuenta);

    /**
     * Actualiza el saldo de una cuenta existente.
     * @param numeroCuenta el número de cuenta a actualizar
     * @param nuevoSaldo el nuevo saldo
     * @return true si se actualizó correctamente
     */
    boolean updateSaldo(String numeroCuenta, BigDecimal nuevoSaldo);

    /**
     * Elimina una cuenta del repositorio.
     * @param cuenta la cuenta a eliminar
     */
    void delete(CuentaBancaria cuenta);

    /**
     * Verifica si existe una cuenta con el número dado.
     * @param numeroCuenta el número de cuenta a verificar
     * @return true si existe la cuenta
     */
    boolean existsByNumeroCuenta(String numeroCuenta);

    /**
     * Cuenta el número total de cuentas en el repositorio.
     * @return cantidad de cuentas
     */
    long count();

    /**
     * Busca cuentas cuyo saldo sea mayor o igual al monto especificado.
     * @param monto el monto mínimo de saldo
     * @return lista de cuentas que cumplen el criterio
     */
    List<CuentaBancaria> findBySaldoGreaterThanEqual(BigDecimal monto);

    /**
     * Busca cuentas cuyo saldo sea menor al monto especificado.
     * Útil para identificar cuentas con saldo bajo.
     * @param monto el monto máximo de saldo
     * @return lista de cuentas que cumplen el criterio
     */
    List<CuentaBancaria> findBySaldoLessThan(BigDecimal monto);
}