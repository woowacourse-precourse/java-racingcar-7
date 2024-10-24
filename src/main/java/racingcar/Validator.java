package racingcar;

public class Validator {
    private final String regex = "[a-zA-Z,]+";
    private final String delimiter = ",";


    public void validateCharacter(String input) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNameLength(String input) {
        String[] names = input.split(delimiter);
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateEmpty(String input) {
        String[] names = input.split(delimiter);
        for (String name : names) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

}
