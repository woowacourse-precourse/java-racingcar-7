package racingcar.view;

import static racingcar.common.exception.ErrorMessage.INPUT_BLANK_ERROR;
import static racingcar.common.exception.ErrorMessage.INPUT_NULL_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_REQUEST_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String inputCarNames() {
        System.out.println(CAR_NAMES_REQUEST_PROMPT);
        return Validator.validateCarNames(Console.readLine());
    }

    private static class Validator {
        private static String validateCarNames(String message) {
            validateNotNull(message);
            validateNotBlank(message);
            return message;
        }

        private static void validateNotNull(String message) {
            if (message == null) {
                throw new IllegalArgumentException(INPUT_NULL_ERROR);
            }
        }

        private static void validateNotBlank(String message) {
            if (message.isBlank()) {
                throw new IllegalArgumentException(INPUT_BLANK_ERROR);
            }
        }
    }
}
