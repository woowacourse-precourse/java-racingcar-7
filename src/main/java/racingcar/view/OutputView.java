package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Name;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.console.Writer;

public class OutputView {

    private static final String WINNER_TITLE = "최종 우승자 : %s";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String RACE_RESULT = "실행 결과";
    private static final String EMPTY = "";

    public void printRaceResultPhrase() {
        Writer.print(RACE_RESULT);
    }

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            Writer.print(car.toString());
        }
        Writer.print(EMPTY);
    }

    public void printWinners(List<Name> winners) {
        Writer.print(generateWinnerFormat(winners));
    }

    private String generateWinnerFormat(List<Name> winners) {
        return String.format(
                WINNER_TITLE,
                winners.stream()
                        .map(Name::getName)
                        .collect(Collectors.joining(WINNER_SEPARATOR))
        );
    }
}
