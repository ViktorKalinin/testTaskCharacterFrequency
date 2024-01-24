package org.example.testtask_character_frequency.services;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharacterFrequencyServiceTest {
    private final CharacterFrequencyService service = new CharacterFrequencyService();

    @Test
    void testValidInput() {
        String inputString = "aaaaabcccc";
        Map<Character, Long> result = service.numberOfCharacters(inputString);

        assertEquals(5, result.get('a'));
        assertEquals(4, result.get('c'));
        assertEquals(1, result.get('b'));
    }

    @Test
    void testInvalidInput(){
        String emptyString = "";

        IllegalArgumentException exceptionForEmptry = assertThrows(IllegalArgumentException.class,
                () -> service.numberOfCharacters(emptyString));
        IllegalArgumentException exceptionForNull = assertThrows(IllegalArgumentException.class,
                () -> service.numberOfCharacters(null));

        assertEquals("Введённая строка не содержит символов", exceptionForEmptry.getMessage());
        assertEquals("Введённая строка не содержит символов", exceptionForNull.getMessage());
    }

}
