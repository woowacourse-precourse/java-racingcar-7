package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ATTEMPT_RESULT_MESSAGE_SEPARATOR = " : ";
    private static final String ATTEMPT_RESULT_MESSAGE_ADVANCE_INDICATOR = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_FORMAT_SEPARATOR = ", ";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printAttemptResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(getAttemptResult(car));
        }
    }

    private String getAttemptResult(RacingCar car) {
        return car.getCarName() + ATTEMPT_RESULT_MESSAGE_SEPARATOR
                + ATTEMPT_RESULT_MESSAGE_ADVANCE_INDICATOR.repeat(car.getAdvanceCount());
    }

    public void printWinner(List<String> winners) {
        System.out.println(WINNER_MESSAGE + getWinnerFormat(winners));
    }

    private String getWinnerFormat(List<String> winners) {
        return String.join(WINNER_FORMAT_SEPARATOR, winners);
    }
}
