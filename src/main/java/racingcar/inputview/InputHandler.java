package racingcar.inputview;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidator;

import javax.xml.validation.Validator;

public class InputHandler {
    private final String delimiter = ",";

    public String[] split(String input) {
        if (InputValidator.isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력이 비어 있거나 공백입니다, 다시 입력해 주세요.");
        }
        // isValidFormat으로만 검사하면 Null이 들어왔을때 NullPointException이 발생하므로 먼저 Null이나 공백인지 검사

        if (!InputValidator.isValidFormat(input)) {
            throw new IllegalArgumentException("포맷에 맞게 입력해 주세요, 자동차 이름은 공백없이 최대 5글자이고 쉼표로 구분 합니다.");

        }
        return input.split(delimiter);
    }

    public int getAttemptGameCount(String input) {

        if (InputValidator.isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력이 비어 있거나 공백입니다, 다시 입력해 주세요.");
        }
        if (!InputValidator.isValidNumber(input)) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해 주세요.");
        }

        return Integer.parseInt(input);
    }


}
