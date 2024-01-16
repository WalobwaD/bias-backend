package com.Housing.Bias.controller;


import com.Housing.Bias.entity.FormEntity;
import com.Housing.Bias.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:3000")
public class FormController {

    @Autowired
    private FormService formservice;

    @GetMapping
    public List<FormEntity> getForm(){
        return Collections.EMPTY_LIST;
    }

    @PostMapping
    public List<FormEntity> postForms(@RequestBody List<FormEntity> forms) {
        return Collections.EMPTY_LIST;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteForm(@PathVariable Long id) {
        return ResponseEntity.ok("Okay");
    }


}
