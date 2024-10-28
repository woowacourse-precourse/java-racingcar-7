package racingcar.validation;

public class Validator {
    private final static String EXCEPTION_MESSAGE = "잘못된 입력입니다.";

    static public void validateEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    static public void validateLengthUpTo5(String input){
        if(input.length()>5){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
