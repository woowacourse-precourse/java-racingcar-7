package racingcar;

public class ValidateCar {
    public static void validateInputCar(String userInput) {
        validateEmptyInput(userInput);
        validateExtraComma(userInput);

        for (String carName : userInput.split(",")) {
            String trimmedPart = carName.trim();
            validateEmptyPart(trimmedPart);
            validateNameLength(trimmedPart);
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
}
