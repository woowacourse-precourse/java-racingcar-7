package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    // Output Messages
    public static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_TITLE = "실행 결과";
    public static final String RESULT_DETAIL = "%s : %s\n";
    public static final String FINAL_RESULT = "최종 우승자 : %s";

    // Delimiter
    private static final String WINNER_DELIMITER = ", ";
    private static final String POSITION_INDICATOR = "-";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printRound(final List<Car> carsList) {
        for (Car car : carsList) {
            final String carName = car.getName();
            final int position = car.getPosition();

            System.out.printf(RESULT_DETAIL, carName, POSITION_INDICATOR.repeat(position));
        }
    }

    public static void printWinners(final List<String> winnersList) {
        String winners = String.join(WINNER_DELIMITER, winnersList);

        System.out.printf(FINAL_RESULT, winners);
    }
}
