package racingcar.validation;

public class ValidateInput {
    public static void throwException() {
        throw new IllegalArgumentException();
    }

    public static void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throwException();
        }
    }


    public static void validateName(String carNames) {
        validateEmpty(carNames);
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            String car = carName.trim();
            if (car.length() > 5 || car.isEmpty() || car.contains(" ")) {
                throwException();
            }
        }
    }

    public static void validateMoveCount(String moveCount) {
        validateEmpty(moveCount);

        try {
            if (Integer.parseInt(moveCount.trim()) < 1) {
                throwException();
            }
        } catch (NumberFormatException e) {
            throwException();
        }
    }
}
