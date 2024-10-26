package racingcar.validate;

public class InputNumberValidation {
    public static int validateInputNumber(String inputNumber) {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException("null이거나 아무 숫자도 입력하지 않았습니다.");
        }
        int numberOfAttempts;
        try {
            numberOfAttempts = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 Integer여야 합니다.");
        }
        return numberOfAttempts;
    }
}
