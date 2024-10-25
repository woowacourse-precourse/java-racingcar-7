package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String WINNERS_DELIMITER = ", ";

    private final List<Car> winners;

    private Winners(final List<Car> winners) {
        this.winners = winners;
    }

    public static Winners createWinners(final List<Car> winners) {
        return new Winners(winners);
    }

    public String displayWinners() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNERS_DELIMITER));
    }
}
