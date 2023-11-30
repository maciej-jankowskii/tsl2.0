package com.example.tsl.model.cargos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
    List<Cargo> findAll();
}
