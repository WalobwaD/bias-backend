package com.Housing.Bias.service;

import com.Housing.Bias.entity.ForbiddenWord;
import com.Housing.Bias.repository.ForbiddenWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public ForbiddenWord addForbiddenWord(String word) {
        ForbiddenWord forbiddenWord =  new ForbiddenWord();
        forbiddenWord.setWord(word);
        return forbiddenWordRepository.save(forbiddenWord); // Case-insensitive addition
    }

    public void removeForbiddenWord(String word) {
        forbiddenWords.remove(word.toLowerCase()); // Case-insensitive removal
    }

    public List<String> findForbiddenInWords(final String textToCheck) {
        final List<String> flaggedWords = forbiddenWordRepository.findAll()
                .stream()
                .map(ForbiddenWord::getWord)
                .collect(Collectors.toUnmodifiableList());

        List<String> flagWordsFound = new ArrayList<>();
        for(String wordPhrase : flaggedWords) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(wordPhrase) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textToCheck);

            if (matcher.find()) {
                flagWordsFound.add(wordPhrase);
            }
        }

        return flagWordsFound;
    }
}
