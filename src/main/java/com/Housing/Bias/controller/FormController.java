package com.Housing.Bias.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;
@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:3000")
public class FormController {

    @Autowired
    private FormService formservice;

    @GetMapping
    public List<Form> getForm(){
        return formservice.getAllForms();
    }

    @PostMapping
    public List<Form> postForms(@RequestBody List<Form> forms) {
        return formservice.createForms(forms);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteForm(@PathVariable Long id) {
        if (formservice.deleteForm(id)) {
            return new ResponseEntity<>("Form with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Form with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }


}
