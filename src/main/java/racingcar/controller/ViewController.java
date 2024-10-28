package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public static final String OUTPUT_FILTER = "최종 우승자 : %s";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        return InputView.readInput();
    }

    public static String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return InputView.readInput();
    }

    public static void printWinners(String[] winners) {
        OutputView.printOutput(OUTPUT_FILTER, winners);
    }

}
