package racingcar.view;

import java.util.List;
import racingcar.entity.Car;

public class OutputView {
    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_NOTIFICATION_MESSAGE = "실행 결과";
    public static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승자 : ";

    private OutputView() {
        throw new IllegalStateException("View Class");
    }

    public static void printGameStartMessage() {
        printMessage(GAME_START_MESSAGE);
    }

    public static void printRequestAttemptMessage() {
        printMessage(REQUEST_ATTEMPT_MESSAGE);
    }

    public static void printRacingResultMessage() {
        printMessage(RESULT_NOTIFICATION_MESSAGE);
    }

    public static void printCarPosition(List<Car> carList) {
        for (Car car : carList) {
            printMessage(car.getPositionString());
        }
        printLineBreak();
    }

    public static void printWinnerMessage(String winnerString) {
        StringBuilder winnerMessage = new StringBuilder(WINNER_NOTIFICATION_MESSAGE);
        winnerMessage.append(winnerString);
        printMessage(winnerMessage.toString());
    }

    public static void printLineBreak() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
