package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.winner.Winner;

public class RacingGameLogFormatter {
    private final String COMMON_FORMAT = "%s : %s";
    private final String DASH = "-";
    private final String WINNER_PREFIX = "최종 우승자";
    private final String WINNER_DELIMITER = ", ";

    public String formatCar(Car car) {
        return COMMON_FORMAT
                .formatted(car.getName(), DASH.repeat(car.getLocation()));
    }

    public String formatWinner(Winner winner) {
        return COMMON_FORMAT
                .formatted(WINNER_PREFIX, String.join(WINNER_DELIMITER, winner.getNames()));
    }
}
