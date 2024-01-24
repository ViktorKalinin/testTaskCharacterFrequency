package org.example.testtask_character_frequency.services;

import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static io.micrometer.common.util.StringUtils.isBlank;

@Service
public class CharacterFrequencyService {
    public Map<Character, Long> numberOfCharacters (String inputString){
        if(isBlank(inputString)){
            throw new IllegalArgumentException("Введённая строка не содержит символов");
        }

        return inputString.codePoints()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
}
