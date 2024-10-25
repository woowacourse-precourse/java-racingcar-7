package racingcar;

public class Car {
    private final String name;

    public Car(final String name) {
        validateNameLength(name);
        validateNameOnlyEnglishAndNumber(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameOnlyEnglishAndNumber(final String name) {
        for (char c : name.toCharArray()) {
            validateCharOnlyEnglishAndNumber(c);
        }
    }

    private void validateCharOnlyEnglishAndNumber(final char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (Character.isDigit(c))) {
            return;
        }

        throw new IllegalArgumentException();
    }
}