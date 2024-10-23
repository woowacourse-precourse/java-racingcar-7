package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UIController {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public String receiveName() {
        OutputView.print(QUESTION_CAR_NAME);
        return validateName(InputView.read());
    }

    public int receiveCount() {
        OutputView.print(QUESTION_TRY_COUNT);
        return validateCount(InputView.read());
    }

    private String validateName(String name) {
        validateBlank(name);
        validateEnglish(name);

        return name;
    }

    private void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("[ERROR]횟수는 0을 입력할 수 없습니다.");
        }
    }

    private boolean isBlank(String input) {
        return input.isBlank();
    }

    private void validateEnglish(String name) {
        if (isNotEnglish(name)) {
            throw new IllegalArgumentException("[ERROR]이름은 영문자만 입력 가능합니다.");
        }
    }

    private boolean isNotEnglish(String name) {
        return !name.matches("^[a-z|A-Z]*$");
    }

    private int validateCount(String count) {
        validateBlank(count);
        return validateNumber(count);
    }

    private int validateNumber(String count) {
        if (isNotPositiveInteger(count)) {
            throw new IllegalArgumentException("[ERROR]횟수는 양의 정수만 입력가능합니다.");
        }
        return Integer.parseInt(count);
    }

    private boolean isNotPositiveInteger(String count) {
        return !count.matches("^[1-9]*$");
    }
}
