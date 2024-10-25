package racingcar;

public class Car {
    private final String name;

    public Car(final String name) {
        validateNameLength(name);
        validateNameOnlyAlphaAndNumber(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameOnlyAlphaAndNumber(final String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            validateCharOnlyAlphaAndNumber(c);
        }
    }

    private void validateCharOnlyAlphaAndNumber(final char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (Character.isDigit(c))) {
            return;
        }

        throw new IllegalArgumentException();
    }
}