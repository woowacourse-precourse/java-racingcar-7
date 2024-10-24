package racingcar.io;

public class Validators implements Validator {


    @Override
    public String validateString(String input) throws IllegalArgumentException {
        String[] words = splitToArray(input);

        return "";
    }

    private String[] splitToArray(String input) {
        String[] words = input.split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].strip();
        }

        return words;
    }

    @Override
    public int validateInteger(String input) throws IllegalArgumentException {
        return 0;
    }
}
