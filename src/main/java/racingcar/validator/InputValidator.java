package racingcar.validator;

import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidInputException;

import java.util.List;

public class InputValidator {

    public static void validateCarNames(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new InvalidCarNameException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new InvalidInputException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }
}
