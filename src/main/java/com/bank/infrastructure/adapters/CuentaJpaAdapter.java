package com.bank.infrastructure.adapters;


import com.bank.domain.model.TipoIdentificacion;
import com.bank.domain.model.CuentaAhorro;
import com.bank.domain.model.CuentaBancaria;
import com.bank.domain.model.Cliente;
import com.bank.domain.ports.CuentaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CuentaJpaAdapter implements CuentaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<CuentaBancaria> findById(UUID id) {
        CuentaBancariaEntity entity = entityManager.find(CuentaBancariaEntity.class, id);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(entity));
    }

    @Override
    public Optional<CuentaBancaria> findByNumeroCuenta(String numeroCuenta) {
        TypedQuery<CuentaBancariaEntity> query = entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c WHERE c.numeroCuenta = :numero",
            CuentaBancariaEntity.class
        );
        query.setParameter("numero", numeroCuenta);
        List<CuentaBancariaEntity> results = query.getResultList();
        if (results.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(results.get(0)));
    }

    @Override
    public List<CuentaBancaria> findByClienteId(UUID clienteId) {
        TypedQuery<CuentaBancariaEntity> query = entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c WHERE c.clienteId = :clienteId",
            CuentaBancariaEntity.class
        );
        query.setParameter("clienteId", clienteId);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<CuentaBancaria> findAll() {
        return entityManager.createQuery(
            "SELECT c FROM CuentaBancariaEntity c",
            CuentaBancariaEntity.class
        ).getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public CuentaBancaria save(CuentaBancaria cuenta) {
        CuentaBancariaEntity entity = mapToEntity(cuenta);
        if (cuenta.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        CuentaBancariaEntity entity = entityManager.find(CuentaBancariaEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public boolean existsByNumeroCuenta(String numeroCuenta) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(c) FROM CuentaBancariaEntity c WHERE c.numeroCuenta = :numero",
            Long.class
        );
        query.setParameter("numero", numeroCuenta);
        return query.getSingleResult() > 0;
    }

    private CuentaBancaria mapToDomain(CuentaBancariaEntity entity) {
        Cliente cliente = new Cliente(
            entity.getClienteNombre(),
            entity.getClienteApellido(),
            entity.getClienteEmail(),
            entity.getClienteFechaNacimiento(),
            entity.getClienteNumeroIdentificacion(),
            Cliente.TipoIdentificacion.valueOf(entity.getClienteTipoIdentificacion())
        );
        
        if ("AHORRO".equals(entity.getTipoCuenta())) {
            CuentaAhorro cuenta = new CuentaAhorro(
                entity.getNumeroCuenta(),
                cliente,
                entity.getSaldo(),
                entity.getTasaInteres()
            );
            return cuenta;
        } else {
            throw new IllegalStateException("Tipo de cuenta no soportado: " + entity.getTipoCuenta());
        }
    }

    private CuentaBancariaEntity mapToEntity(CuentaBancaria cuenta) {
        CuentaBancariaEntity entity = new CuentaBancariaEntity();
        entity.setId(cuenta.getId());
        entity.setNumeroCuenta(cuenta.getNumeroCuenta());
        entity.setSaldo(cuenta.getSaldo());
        entity.setFechaCreacion(cuenta.getFechaCreacion());
        
        if (cuenta instanceof CuentaAhorro cuentaAhorro) {
            entity.setTipoCuenta("AHORRO");
            entity.setTasaInteres(cuentaAhorro.getTasaInteres());
        }
        
        Cliente cliente = cuenta.getCliente();
        entity.setClienteId(cliente.getId());
        entity.setClienteNombre(cliente.getNombre());
        entity.setClienteApellido(cliente.getApellido());
        entity.setClienteEmail(cliente.getEmail());
        entity.setClienteFechaNacimiento(cliente.getFechaNacimiento());
        entity.setClienteNumeroIdentificacion(cliente.getNumeroIdentificacion());
        entity.setClienteTipoIdentificacion(cliente.getTipoIdentificacion().name());
        
        return entity;
    }

    @Entity
    @Table(name = "cuentas_bancarias")
    public static class CuentaBancariaEntity {
        @Id
        private UUID id;
        
        @Column(name = "numero_cuenta", unique = true, nullable = false)
        private String numeroCuenta;
        
        @Column(name = "saldo", nullable = false)
        private BigDecimal saldo;
        
        @Column(name = "fecha_creacion", nullable = false)
        private LocalDateTime fechaCreacion;
        
        @Column(name = "tipo_cuenta", nullable = false)
        private String tipoCuenta;
        
        @Column(name = "tasa_interes")
        private BigDecimal tasaInteres;
        
        @Column(name = "cliente_id", nullable = false)
        private UUID clienteId;
        
        @Column(name = "cliente_nombre", nullable = false)
        private String clienteNombre;
        
        @Column(name = "cliente_apellido", nullable = false)
        private String clienteApellido;
        
        @Column(name = "cliente_email")
        private String clienteEmail;
        
        @Column(name = "cliente_fecha_nacimiento")
        private java.time.LocalDate clienteFechaNacimiento;
        
        @Column(name = "cliente_numero_identificacion")
        private String clienteNumeroIdentificacion;
        
        @Column(name = "cliente_tipo_identificacion")
        private String clienteTipoIdentificacion;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNumeroCuenta() { return numeroCuenta; }
        public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
        public BigDecimal getSaldo() { return saldo; }
        public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
        public LocalDateTime getFechaCreacion() { return fechaCreacion; }
        public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
        public String getTipoCuenta() { return tipoCuenta; }
        public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
        public BigDecimal getTasaInteres() { return tasaInteres; }
        public void setTasaInteres(BigDecimal tasaInteres) { this.tasaInteres = tasaInteres; }
        public UUID getClienteId() { return clienteId; }
        public void setClienteId(UUID clienteId) { this.clienteId = clienteId; }
        public String getClienteNombre() { return clienteNombre; }
        public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
        public String getClienteApellido() { return clienteApellido; }
        public void setClienteApellido(String clienteApellido) { this.clienteApellido = clienteApellido; }
        public String getClienteEmail() { return clienteEmail; }
        public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }
        public java.time.LocalDate getClienteFechaNacimiento() { return clienteFechaNacimiento; }
        public void setClienteFechaNacimiento(java.time.LocalDate clienteFechaNacimiento) { this.clienteFechaNacimiento = clienteFechaNacimiento; }
        public String getClienteNumeroIdentificacion() { return clienteNumeroIdentificacion; }
        public void setClienteNumeroIdentificacion(String clienteNumeroIdentificacion) { this.clienteNumeroIdentificacion = clienteNumeroIdentificacion; }
        public String getClienteTipoIdentificacion() { return clienteTipoIdentificacion; }
        public void setClienteTipoIdentificacion(String clienteTipoIdentificacion) { this.clienteTipoIdentificacion = clienteTipoIdentificacion; }
    }
}