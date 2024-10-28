package racingcar.domain;

public class Validator {
    public static final String INVALID_INPUT_ERROR = "값이 입력되지 않았습니다.";

    public static void validateInput(String input){
        if(input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
