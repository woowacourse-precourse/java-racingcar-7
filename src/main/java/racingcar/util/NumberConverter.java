package racingcar.util;

public class NumberConverter {
    public int convert(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return num;
    }
}
