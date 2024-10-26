package model;

public class InputHandler {

    public String[] splitCarNames(String input) {
        String regex = "^([a-zA-Z0-9]{1,5})(,[a-zA-Z0-9]{1,5})*$";
        checkInput(input, regex);

        return input.split(",");
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
