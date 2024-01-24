package org.example.testtask_character_frequency.controllers;

import org.example.testtask_character_frequency.services.CharacterFrequencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterFrequencyControllerTest {


    @Mock
    private CharacterFrequencyService service;

    @InjectMocks
    private CharacterFrequencyController controller;

    @Test
    void testValidGetNumberOfCharacter(){
        String inputString = "abbaac";
        Map<Character, Long> resultMap = new HashMap<>();
        resultMap.put('a', 3L);
        resultMap.put('b', 2L);
        resultMap.put('c', 1L);

        when(service.numberOfCharacters(inputString)).thenReturn(resultMap);

        ResponseEntity<Map<Character, Long>> response = controller.getNumberOfCharacter(inputString);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(resultMap, response.getBody());
    }

    @Test
    void testInvalidGetNumberOfCharacter(){
        String emptyString = "";
        String nullString = null;

        ResponseEntity<Map<Character, Long>> responseOne = controller.getNumberOfCharacter(emptyString);
        ResponseEntity<Map<Character, Long>> responseTwo = controller.getNumberOfCharacter(nullString);

        assertEquals(HttpStatus.BAD_REQUEST, responseOne.getStatusCode());
        assertNull(responseTwo.getBody());
    }
}
