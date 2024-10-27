package racingcar.view;

import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;
import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;

public class InputView {
    private static final String REQUEST_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String requestCarsName() {
        ConsoleWriter.printlnMessage(REQUEST_CARS_MESSAGE);
        String input = ConsoleReader.enterMessage();
        if (isEmptyOrBlank(input)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
        return input;
    }

    public int requestRoundCount() {
        ConsoleWriter.printlnMessage(REQUEST_ROUND_COUNT_MESSAGE);
        String input = ConsoleReader.enterMessage();
        if (isEmptyOrBlank(input)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
        if (isNotPositiveInteger(input)) {
            throw CustomException.of(ErrorMessage.INVALID_ROUND_COUNT_ERROR);
        }
        return Integer.parseInt(input);
    }

    private boolean isEmptyOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private boolean isNotPositiveInteger(String str) {
        return !str.matches("\\d+") || Integer.parseInt(str) <= 0;
    }

}