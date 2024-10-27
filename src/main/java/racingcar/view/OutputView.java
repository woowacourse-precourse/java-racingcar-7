package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
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
        System.out.println();
    }

    private String getAttemptResult(RacingCar car) {
        return car.getCarName() + ATTEMPT_RESULT_MESSAGE_SEPARATOR
                + ATTEMPT_RESULT_MESSAGE_ADVANCE_INDICATOR.repeat(car.getAdvanceCount());
    }

    public void printWinner(List<RacingCar> winners) {
        System.out.println(WINNER_MESSAGE + getWinnerFormat(extractWinnerName(winners)));
    }

    private String getWinnerFormat(List<String> winners) {
        return String.join(WINNER_FORMAT_SEPARATOR, winners);
    }

    private List<String> extractWinnerName(List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
