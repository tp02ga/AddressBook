package com.coderscampus.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Contact;

@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
