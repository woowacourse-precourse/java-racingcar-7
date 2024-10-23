package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

public class NameExtractor {
    private static final String NAME_DELIMITER = ",";

    public static List<String> extractNames(String string){
        return List.of(string.split(NAME_DELIMITER)).stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
