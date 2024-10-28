package racingcar.model;

public class Validator {

    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름을 쉼표로 구분해야 합니다.");
        }

        String[] carNames = input.split(",");
        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}