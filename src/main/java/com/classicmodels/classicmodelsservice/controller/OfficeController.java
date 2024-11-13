package com.classicmodels.classicmodelsservice.controller;

import org.springframework.web.bind.annotation.*;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.classicmodels.classicmodelsservice.entity.Office;
import com.classicmodels.classicmodelsservice.service.OfficeService;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    @Autowired
    private OfficeService service;

    @GetMapping
    public List<Office> findAll() {
        return service.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Office findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Office save(@RequestBody Office office) {
        return service.save(office);
    }

    @DeleteMapping("/<built-in function id>")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}