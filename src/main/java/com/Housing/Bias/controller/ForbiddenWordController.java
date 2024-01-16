package com.Housing.Bias.controller;

import com.Housing.Bias.service.ForbiddenWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ForbiddenWordController{
    private ForbiddenWordsService forbiddenWordsService;

    @Autowired
    public void ForbiddenWordsController(ForbiddenWordsService forbiddenWordsService) {
        this.forbiddenWordsService = forbiddenWordsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> getAllForbiddenWords() {
        List<String> forbiddenWords = forbiddenWordsService.getAllForbiddenWords();
        return new ResponseEntity<>(forbiddenWords, HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkWord(@RequestBody String word) {
        if (forbiddenWordsService.isForbidden(word)) {
            return new ResponseEntity<>("Word is forbidden.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Word is allowed.", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addForbiddenWord(@RequestBody String word) {
        forbiddenWordsService.addForbiddenWord(word);
        return new ResponseEntity<>("Forbidden word added successfully.", HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeForbiddenWord(@RequestBody String word) {
        forbiddenWordsService.removeForbiddenWord(word);
        return new ResponseEntity<>("Forbidden word removed successfully.", HttpStatus.OK);
    }
}
