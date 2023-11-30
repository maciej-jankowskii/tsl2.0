package com.example.tsl.model.contractors.repository;

import com.example.tsl.model.contractors.contactPerson.ContractorContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractorContactPersonRepository extends CrudRepository<ContractorContactPerson, Long> {
    List<ContractorContactPerson> findAll();
    List<ContractorContactPerson> findAllByContractorId(Long id);
}
