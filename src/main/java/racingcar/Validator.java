package racingcar;

public class Validator {
    private final String regex = "[a-zA-Z, ]+";
    private final String delimiter = ",";

    public String [] validate(String input){
        validateCharacter(input);
        String[] names = splitNames(input);
        validateEmpty(names);
        validateNameLength(names);
        return names;
    }

    private String[] splitNames(String input) {
        return input.split(delimiter);
    }


    public void validateCharacter(String input) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("알파벳과 ,(쉼표)만 입력 가능합니다.");
        }
    }

    public void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 5이하만 가능합니다.");
            }
        }
    }

    public void validateEmpty(String[] names) {
        for (String name : names) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("이름은 공백이 안됩니다.");
            }
        }
    }

}
