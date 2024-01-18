package com.Housing.Bias.controller;

import com.Housing.Bias.entity.ForbiddenWord;
import com.Housing.Bias.service.ForbiddenWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forbidden")
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
    public List<String> checkForbiddenWords(@RequestBody String textToCheck) {
        return forbiddenWordsService.findForbiddenInWords(textToCheck);
    }

    @PostMapping
    public ForbiddenWord addForbiddenWord(@RequestBody String word) {
        return forbiddenWordsService.addForbiddenWord(word);
    }

    @DeleteMapping
    public ResponseEntity<String> removeForbiddenWord(@RequestBody String word) {
        forbiddenWordsService.removeForbiddenWord(word);
        return new ResponseEntity<>("Forbidden word removed successfully.", HttpStatus.OK);
    }
}
