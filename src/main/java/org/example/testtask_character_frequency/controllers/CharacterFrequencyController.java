package org.example.testtask_character_frequency.controllers;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.example.testtask_character_frequency.services.CharacterFrequencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


/**
 * REST контроллер для вычисления частоты встречи символов в заданной строке.
 */
@RestController
@RequiredArgsConstructor
public class CharacterFrequencyController {

    private final CharacterFrequencyService frequencyService;

    @PostMapping("/getNumberOfCharacter")
    public ResponseEntity<Map<Character, Long>> getNumberOfCharacter(@RequestBody @Size(max = 200) String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Map<Character, Long> result = frequencyService.numberOfCharacters(inputString);
        return ResponseEntity.ok(result);
    }
}
