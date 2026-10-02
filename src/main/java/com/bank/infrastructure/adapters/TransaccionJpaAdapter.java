package com.bank.infrastructure.adapters;

import com.bank.domain.model.Transaccion;
import com.bank.domain.model.Transaccion.TipoTransaccion;
import com.bank.domain.ports.TransaccionRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TransaccionJpaAdapter implements TransaccionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Transaccion> findById(UUID id) {
        TransaccionEntity entity = entityManager.find(TransaccionEntity.class, id);
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToDomain(entity));
    }

    @Override
    public List<Transaccion> findByCuentaId(UUID cuentaId) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.cuentaId = :cuentaId ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("cuentaId", cuentaId);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<Transaccion> findByCuentaIdAndFechaBetween(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.cuentaId = :cuentaId AND t.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public List<Transaccion> findAll() {
        return entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t ORDER BY t.fecha DESC",
            TransaccionEntity.class
        ).getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        TransaccionEntity entity = mapToEntity(transaccion);
        if (transaccion.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        TransaccionEntity entity = entityManager.find(TransaccionEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public List<Transaccion> findByTipo(TipoTransaccion tipo) {
        TypedQuery<TransaccionEntity> query = entityManager.createQuery(
            "SELECT t FROM TransaccionEntity t WHERE t.tipo = :tipo ORDER BY t.fecha DESC",
            TransaccionEntity.class
        );
        query.setParameter("tipo", tipo.name());
        return query.getResultList().stream()
            .map(this::mapToDomain)
            .toList();
    }

    private Transaccion mapToDomain(TransaccionEntity entity) {
        return new Transaccion(
            entity.getId(),
            entity.getCuentaId(),
            TipoTransaccion.valueOf(entity.getTipo()),
            entity.getMonto(),
            entity.getFecha(),
            entity.getDescripcion()
        );
    }

    private TransaccionEntity mapToEntity(Transaccion transaccion) {
        TransaccionEntity entity = new TransaccionEntity();
        entity.setId(transaccion.getId());
        entity.setCuentaId(transaccion.getCuentaId());
        entity.setTipo(transaccion.getTipo().name());
        entity.setMonto(transaccion.getMonto());
        entity.setFecha(transaccion.getFecha());
        entity.setDescripcion(transaccion.getDescripcion());
        return entity;
    }

    @Entity
    @Table(name = "transacciones")
    public static class TransaccionEntity {
        @Id
        private UUID id;
        
        @Column(name = "cuenta_id", nullable = false)
        private UUID cuentaId;
        
        @Column(name = "tipo", nullable = false)
        private String tipo;
        
        @Column(name = "monto", nullable = false)
        private BigDecimal monto;
        
        @Column(name = "fecha", nullable = false)
        private LocalDateTime fecha;
        
        @Column(name = "descripcion")
        private String descripcion;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public UUID getCuentaId() { return cuentaId; }
        public void setCuentaId(UUID cuentaId) { this.cuentaId = cuentaId; }
        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }
        public BigDecimal getMonto() { return monto; }
        public void setMonto(BigDecimal monto) { this.monto = monto; }
        public LocalDateTime getFecha() { return fecha; }
        public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    }
}