package com.example.tsl.model.contractors.repository;

import com.example.tsl.model.contractors.carrier.Carrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrierRepository extends CrudRepository<Carrier, Long> {
    List<Carrier> findAll();
}
