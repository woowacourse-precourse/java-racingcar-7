package racingcar.view;

import racingcar.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PROGRESS_BAR = "-";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String SEPARATOR = " : ";
    private static final String WINNER_PRINT_MESSAGE = "최종 우승자";
    private static final String DELIMITER_COMMA = ", ";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingProgress(RacingGame racingGame) {

        for (Car car : racingGame.getCars()) {
            Name name = car.getName();
            Position position = car.getPosition();
            System.out.println(name.getName() + SEPARATOR + PROGRESS_BAR.repeat(position.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(RacingGame racingGame) {
        String winner = racingGame.resultWinnerNames()
                .stream()
                .map(Name::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(WINNER_PRINT_MESSAGE + SEPARATOR + winner);
    }
}
