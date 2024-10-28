package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public static final String OUTPUT_FILTER = "최종 우승자 : %s";

    public static String readCarNames() {
        System.out.println(INPUT_CAR_NAME);
        return InputView.readInput();
    }

    public static String readTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return InputView.readInput();
    }

    public static void printStartRacePhrase() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRaceProcess(List<Car> cars) {
        OutputView.printRaceResult(cars);
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        OutputView.printOutput(OUTPUT_FILTER, winners);
    }
}