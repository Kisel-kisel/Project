package com.example.homeworkfirstspring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {

    private final List<Schedule> list;

    public ScheduleController(){
        list = new ArrayList<>();
        list.add(new Schedule("Java"));
        list.add(new Schedule("Algoritms"));
        list.add(new Schedule("JavaScript"));
    }


    @GetMapping(value = "/scheduleGet")
    public List<Schedule> getSchedule(){
        return list;
    }
    @PostMapping(value = "/schedulePost")
    public List<Schedule> postSchedule(){
        return list;
    }

    @DeleteMapping(value = "/scheduleDelete/{id}")
    public void deleteSchedule(@RequestBody String id){
        int idNumber = Integer.parseInt(id);
        list.remove(idNumber);
    }
    @PutMapping(value = "/schedulePut/{id}")
    public void putSchedule(@PathVariable String id, @RequestBody Schedule lesson){
        int idNumber = Integer.parseInt(id);
        list.set(idNumber,lesson);
    }
}
