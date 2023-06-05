package com.javapractice.JsonDB.controllers;

import com.javapractice.JsonDB.entity.Table;
import com.javapractice.JsonDB.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    DatabaseRepository databaseRepository;

    public DatabaseController(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }
    @Async
    @GetMapping("/")
    public String mainPage() {
        return databaseRepository.findAll().toString();
    }

    @Async
    @PostMapping("/create")
    public String createNewLighting(
            @RequestBody Table table){
        databaseRepository.save(table);
        return databaseRepository.findAll().toString();
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getLightingForEdit(@PathVariable("id") Long id, Model model) {
        List<Table> arr = new ArrayList<>();
        arr.add(databaseRepository.getByID(id));
        model.addAttribute("lighting", arr);
        return databaseRepository.findAll().toString();
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editLighting(
            @RequestBody Table table){
        databaseRepository.update(table);
        return databaseRepository.getByID(table.getId()).toString();
    }
    @Async
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        databaseRepository.delete(id);
        return databaseRepository.findAll().toString();
    }
}
