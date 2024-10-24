package racingcar.domain;

public class Input {

    private final String names;

    private Input(String names) {
        Validator.validateInput(names);
        this.names = names;
    }

    public static Input from(String text) {
        return new Input(text);
    }

    public String getNames() {
        return names;
    }

    private static class Validator {

        private static void validateInput(String text) {
            validateNonEmptyInput(text);
        }

        private static void validateNonEmptyInput(String text) {
            if (text == null || text.isEmpty() || text.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }
        }

    }

}