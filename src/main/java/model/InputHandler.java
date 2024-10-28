package model;

import java.util.Arrays;

public class InputHandler {

    public String[] splitCarNames(String input) {
        String regex = "^([a-zA-Z0-9가-힣]{1,5})(,[a-zA-Z0-9가-힣]{1,5})*$";
        checkInput(input, regex);

        String[] splitted = input.split(",");
        return Arrays.stream(splitted).distinct().toArray(String[]::new);
    }

    public int toInt(String input) {
        String regex = "^([0-9]+)$";
        checkInput(input, regex);

        return Integer.parseInt(input);
    }

    private void checkInput(String input, String regex) {
        boolean isMatch = input.matches(regex);
        if (!isMatch) {
            throw new IllegalArgumentException();
        }
    }

}
