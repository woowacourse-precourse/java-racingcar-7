package model;

public class InputHandler {

    public String[] splitCarNames(String input) {
        // TODO: 에러 처리
        return input.split(",");
    }

    public int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

}
