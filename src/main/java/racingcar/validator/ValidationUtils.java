package racingcar.validator;

public class ValidationUtils {

    public static void checkIfNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있거나 공백으로 이루어져 있습니다.");
        }
    }

}
