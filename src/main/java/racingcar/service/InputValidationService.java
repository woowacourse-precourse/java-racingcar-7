package racingcar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.exceptions.CarNameException;
import racingcar.exceptions.InvalidInputException;

public class InputValidationService implements ValidationService {

    private void isValidFormat(String carInput) {
        if (carInput.startsWith(",") || carInput.endsWith(",")) {
            throw new InvalidInputException();
        }
    }

    private boolean isValidName(String name) {
        int length = name.length();
        return (!name.isEmpty() && length <= 5);
    }

    public void verify(String input) {
        if (input.isEmpty()) {
            throw new InvalidInputException();
        }

        List<String> names = List.of(input.split(","));
        Map<String, Boolean> bitMap = new HashMap<>();

        for (String name : names) {
            boolean isDuplicate = bitMap.getOrDefault(name, false);

            if (isDuplicate) {
                throw new CarNameException();
            }

            if (!isValidName(name)) {
                throw new InvalidInputException();
            }

            bitMap.put(name, true);
        }

        isValidFormat(input);
    }
}
