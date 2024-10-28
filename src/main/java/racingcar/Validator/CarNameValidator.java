package racingcar.Validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    private final int MAX_NAME_LENGTH = 5;

    public void inputNotMoreThanFiveCharacter(String carName) {
        if(isOverFiveCharacter(carName)) {
            throw new IllegalArgumentException("이름을 5자 이하로 입력해주세요");
        }
    }

    private boolean isOverFiveCharacter(String carName) {
        return carName.length() > MAX_NAME_LENGTH;
    }
}
