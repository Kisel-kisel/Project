package com.vlad12.firstproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private final List<Person> list;

    public PersonController(){
        list = new ArrayList<>();
        list.add(new Person(UUID.randomUUID(),"VLAD"));
        list.add(new Person(UUID.randomUUID(),"MAKS"));
        list.add(new Person(UUID.randomUUID(),"VAKS"));
    }

    @GetMapping(value ="/person")
    public List<Person> getPerson(){
        return list;
    }

    @GetMapping(value = "/person/{id}")
    public  Person getPersonFromId(@PathVariable String id){
        int idNumber = Integer.parseInt(id);
        return  list.get(idNumber);
    }

    @PostMapping(value = "/person")
    public Person addPerson(@RequestBody Person person){
        list.add(person);
        return person;
    }
    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable String id){
        int idNumber = Integer.parseInt(id);
      list.remove(idNumber);
    }
<<<<<<< HEAD
=======

>>>>>>> 0842e8f (add)
    @PutMapping(value = "/person/{id}")
    public void updatePerson(@RequestBody Person person,@PathVariable String id){
        int idNumber = Integer.parseInt(id);
        list.set(idNumber, person);
    }
}


















//    @GetMapping(value = "/hello/{a}")
//    public String helloWorld(@PathVariable String a){
//        return "hello world" + a;
//    }
//    @GetMapping(value = "/sum")
//    public String sum(@RequestParam String first, @RequestParam String second){
//        return first + second;
//    }