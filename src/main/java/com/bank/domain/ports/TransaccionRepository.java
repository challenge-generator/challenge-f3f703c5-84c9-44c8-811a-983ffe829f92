package com.bank.domain.ports;

import com.bank.domain.model.Transaccion;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransaccionRepository {
    Transaccion save(Transaccion transaccion);
    Optional<Transaccion> findById(UUID id);
    List<Transaccion> findAll();
    List<Transaccion> findByCuentaOrigenId(UUID cuentaOrigenId);
    List<Transaccion> findByCuentaDestinoId(UUID cuentaDestinoId);
    List<Transaccion> findByCuentaId(UUID cuentaId);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}