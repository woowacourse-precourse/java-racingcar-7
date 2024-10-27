package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_ATTEMPT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNING_MESSAGE = "최종 우승자";
    private static final String SEPARATOR_COLON = " : ";
    private static final String SEPARATOR_REST = ", ";
    private static final String PROGRESS = "-";

    public static void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void printTotalAttemptInputMessage() {
        System.out.println(TOTAL_ATTEMPT_INPUT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarState(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + SEPARATOR_COLON + PROGRESS.repeat(car.getMovedDistance()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print(WINNING_MESSAGE + SEPARATOR_COLON + String.join(SEPARATOR_REST, winners));
    }
}
