package com.example.hari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hari.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
