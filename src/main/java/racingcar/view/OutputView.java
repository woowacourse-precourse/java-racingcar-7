package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.formatter.PrintFormatter;

public class OutputView {
    private final PrintFormatter printFormatter;
    private static final String ASK_INPUT_RACER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_INPUT_TRIAL_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String ROUND_RESULT = "\n실행 결과";

    public OutputView(final PrintFormatter printFormatter) {
        this.printFormatter = printFormatter;
    }

    public void printAskInputRacerName() {
        printMessage(ASK_INPUT_RACER_NAME);
    }

    public void printAskInputTrialCount() {
        printMessage(ASK_INPUT_TRIAL_COUNT);
    }

    public void printRoundResultStart() {
        printMessage(ROUND_RESULT);
    }

    public void printRoundResultDetail(List<Car> cars) {
        for (Car car : cars) {
            printMessage(printFormatter.formatRoundResult(car));
        }
        printMessage("");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
