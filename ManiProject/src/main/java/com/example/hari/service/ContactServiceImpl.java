package com.example.hari.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hari.entity.Contact;
import com.example.hari.repository.ContactRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class ContactServiceImpl implements ContactServiceI {
	
	@Autowired
 private  ContactRepository contactRepository;
 
	@Override 
	public boolean saveContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if(save !=null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepository.findAll();
	Stream<Contact> stream = contacts.stream();
	Stream<Contact> filter = stream.filter(contact -> contact.getActiveSwitch()=='y');
	List<Contact> collect = filter.collect(Collectors.toList());
	
		return collect;
	}

	
	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if( save== null) {
			return false;
		}else {
		return true;
	}
	}
	@Override
	public boolean deleteById(Integer cid) {
		boolean existsById = contactRepository.existsById(cid);
		if(existsById) {
			contactRepository.deleteById(cid);
			return true;
		}else {

		
		return false;
	}
	}

	@Override
	public Optional<Contact> getContactById(Integer cid) {
		Optional<Contact> findById = contactRepository.findById(cid);
		if(findById.isPresent()) {
			return findById;
		}else {
		return null;
		}
	}

	}
