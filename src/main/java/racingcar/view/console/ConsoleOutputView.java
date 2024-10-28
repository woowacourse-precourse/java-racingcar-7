package racingcar.view.console;

import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_REQUEST_MESSAGE = "시도할 횟수를 입력하세요.";

    public void printCarNamesRequest() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    public void printTryCountRequest() {
        System.out.println(TRY_COUNT_REQUEST_MESSAGE);
    }
}
