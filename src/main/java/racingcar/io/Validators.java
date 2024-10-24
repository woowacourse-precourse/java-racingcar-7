package racingcar.io;

public class Validators implements Validator {


    @Override
    public String validateString(String input) throws IllegalArgumentException {
        String[] words = splitToArray(input);

        for (String word : words) {
            if (!isLengthInRange(word)) {
                throw new IllegalArgumentException("잘못된 자동차 이름 입력");
            }
        }




        return "";
    }

    private String[] splitToArray(String input) {
        if (input.indexOf(",") == 0 || input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입력");
        }

        String[] words = input.split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].strip();
        }

        return words;
    }

    private boolean isLengthInRange(String s) {
        if (s.isEmpty() || s.length() > 5) {
            return false;
        }

        return true;
    }

    @Override
    public int validateInteger(String input) throws IllegalArgumentException {
        return 0;
    }
}
