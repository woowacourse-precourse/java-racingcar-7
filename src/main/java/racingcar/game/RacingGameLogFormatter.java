package racingcar.game;

import racingcar.Car;

import java.util.Iterator;
import java.util.List;

public class RacingGameLogFormatter {
    private final String COMMON_FORMAT = "%s : %s";
    private final String DASH = "-";
    private final String WINNER_PREFIX = "최종 우승자";
    private final String WINNER_DELIMITER = ", ";

    public String formatCar(Car car) {
        return COMMON_FORMAT
                .formatted(car.getName(), DASH.repeat(car.getLocation()));
    }

    public String formatWinner(List<Car> winners) {
        return COMMON_FORMAT
                .formatted(WINNER_PREFIX, String.join(WINNER_DELIMITER, toNames(winners)));
    }

    private List<String> toNames(List<Car> winners) {
        return winners.stream().map(Car::getName).toList();
    }

}
