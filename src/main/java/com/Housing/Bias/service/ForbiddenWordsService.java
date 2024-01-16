package com.Housing.Bias.service;

import com.Housing.Bias.entity.ForbiddenWord;
import com.Housing.Bias.repository.ForbiddenWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForbiddenWordsService {

    private final ForbiddenWordRepository forbiddenWordRepository;

    @Autowired
    public ForbiddenWordsService(ForbiddenWordRepository forbiddenWordRepository) {
        this.forbiddenWordRepository = forbiddenWordRepository;
    }

    public boolean containsForbiddenWords(String comment) {
        List<ForbiddenWord> forbiddenWords = forbiddenWordRepository.findAll();

        for (ForbiddenWord forbiddenWord : forbiddenWords) {
            if (comment.contains(forbiddenWord.getWord())) {
                return true;
            }
        }

        return false;
    }
    private final List<String> forbiddenWords = new ArrayList<>();
    public List<String> getAllForbiddenWords() {
        return forbiddenWords;
    }

    public boolean isForbidden(String word) {
        return forbiddenWords.contains(word.toLowerCase()); // Case-insensitive check
    }

    public void addForbiddenWord(String word) {
        forbiddenWords.add(word.toLowerCase()); // Case-insensitive addition
    }

    public void removeForbiddenWord(String word) {
        forbiddenWords.remove(word.toLowerCase()); // Case-insensitive removal
    }
}
