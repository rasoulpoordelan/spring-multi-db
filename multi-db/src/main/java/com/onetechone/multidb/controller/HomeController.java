package com.onetechone.multidb.controller;

import com.onetechone.multidb.model.db1.Person;
import com.onetechone.multidb.model.db2.Department;
import com.onetechone.multidb.service.DepartmentService;
import com.onetechone.multidb.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Autowired
  private PersonService personService;

  @Autowired
  private DepartmentService departmentService;

  @RequestMapping(value = "person/add", method = RequestMethod.POST)
  @Transactional
  public Person savePerson(@RequestBody Person model) {
    return personService.save(model);
  }

  @RequestMapping(value = "person", method = RequestMethod.GET)
  public List<Person> getPeople() {
    return personService.getAll();
  }

  @RequestMapping(value = "department/add", method = RequestMethod.POST)
  @Transactional(transactionManager = "secTransactionManager")
  public Department saveDepartment(@RequestBody Department model) {
    return departmentService.save(model);
  }

  @RequestMapping(value = "department", method = RequestMethod.GET)
  public List<Department> getDepartments() {
    return departmentService.getAll();
  }

  //it just roll back sec transaction
  @RequestMapping(value = "mix", method = RequestMethod.POST)
  @Transactional(transactionManager = "secTransactionManager")
  public String add(@RequestBody Person model)  {
    Person person = new Person();
    person.setName(model.getName());
    person.setCity(model.getCity());

     Department department = new Department();
     department.setName(model.getName());

    personService.save(person);

    departmentService.save(department);

    if (model.getName().equals("er")) {
      throw new RuntimeException();
    }

    return "ok";
  }

}
