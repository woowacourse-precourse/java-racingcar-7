package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionSymbols());
    }

    public void printWinners(List<String> winners) {
        System.out.println(FINAL_WINNER_MESSAGE + String.join(", ", winners));
    }
}