package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final String DELIMITER = ",";

    public List<String> validateUniqueNames(String input) {
        List<String> uniqueNames = new ArrayList<>();

        String[] parsedNames = input.split(DELIMITER);
        for (String name : parsedNames) {
            if (uniqueNames.contains(name)) {
                throw new IllegalArgumentException();
            }
            uniqueNames.add(name);
        }
        return uniqueNames;
    }
}
