package racingcar;

public abstract class Validator {
    private static final int MAX_LENGTH = 5;

    public static String validateNameLength(String names) {
        if (names.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    public static int validateCount(String count) {
        int countAsInt = Integer.parseInt(count);
        if (countAsInt < 0) {
            throw new IllegalArgumentException();
        }
        return countAsInt;
    }
}
