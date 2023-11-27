package com.example.tsl.model.contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends CrudRepository<ContactForm, Long> {
}
