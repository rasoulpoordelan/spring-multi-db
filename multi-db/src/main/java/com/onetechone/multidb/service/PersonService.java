package com.onetechone.multidb.service;


import com.onetechone.multidb.model.db1.Person;
import com.onetechone.multidb.repository.db1.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  public List<Person> getAll() {
    return personRepository.findAll();
  }

  public Person save(Person person) {
    return personRepository.save(person);
  }
}