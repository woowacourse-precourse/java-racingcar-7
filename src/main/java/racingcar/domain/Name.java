package racingcar.domain;

import static racingcar.exception.ExceptionMessage.BLANK_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_NAME_LENGTH;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException(BLANK_NAME.getMessage());
        }
    }

    private void validateLength(String name) {
        if(name.length()>MAX_LENGTH){
            throw new IllegalArgumentException(OUT_OF_NAME_LENGTH.getMessage());
        }
    }
}
