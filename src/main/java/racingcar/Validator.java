package racingcar;

import java.util.List;

public class Validator {
    public static int InputNumValidator(String intInput) {
        if (intInput.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }

        int number;

        try {
            number = Integer.parseInt(intInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }

        return number;
    }
}
