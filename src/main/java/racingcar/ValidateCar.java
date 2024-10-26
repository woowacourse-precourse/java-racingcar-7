package racingcar;

import java.util.HashSet;
import java.util.Set;

public class ValidateCar {
    /*public static List<String> manageCar(String userInputCar) {
        validateInputCar(userInputCar);
        return ParsingCar.parseInputCarToList(userInputCar);
    }*/

    public static void validateInputCar(String userInput) {
        validateEmptyInput(userInput);
        validateExtraComma(userInput);

        Set<String> carNames = new HashSet<>();
        for (String carName : userInput.split(",", -1)) {
            String trimmedPart = carName.trim();
            validateEmptyPart(trimmedPart);
            validateNameLength(trimmedPart);
            validateDuplicateNames(trimmedPart, carNames);
        }
    }

    private static void validateEmptyInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateExtraComma(String userInput) {
        String[] splitUserInputTemp = userInput.split(",");
        if (splitUserInputTemp.length == 0) {
            throw new IllegalArgumentException("쉼표만 입력되었습니다.");
        }
    }

    private static void validateEmptyPart(String trimmedPart) {
        if (trimmedPart.isEmpty()) {
            throw new IllegalArgumentException("쉼표 뒤에 이름이 들어오지 않았습니다.");
        }
    }

    private static void validateNameLength(String trimmedPart) {
        if (trimmedPart.length() > 5) {
            throw new IllegalArgumentException("이름이 5자를 초과합니다.");
        }
    }

    private static void validateDuplicateNames(String carName, Set<String> carNames) {
        if (!carNames.add(carName)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
