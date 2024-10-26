package racingcar;

import java.util.List;

public class Valid {
    public List<String> validCarsName(String rawUserInput) {
        if (rawUserInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] splitedUserInputCarsNames = rawUserInput.split(",");

        for (String userInputCarName : splitedUserInputCarsNames) {
            if (userInputCarName.isBlank()) {
                throw new IllegalArgumentException();
            } else if (userInputCarName.length() > 5) {
                throw new IllegalArgumentException();
            } else if (!userInputCarName.matches("^[a-zA-Z0-9]{1,5}$")) {
                throw new IllegalArgumentException();
            } else {
            }
        }
        return List.of(splitedUserInputCarsNames);
    }

    public int validRoundTime(String rawInt) {
        try {
            return Integer.parseInt(rawInt);
        } catch (NumberFormatException e) {
            throw (new IllegalArgumentException());
        }
    }
}
