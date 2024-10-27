package racingcar.game;

import racingcar.Car;

public class RacingGameLogFormatter {
    private final String CAR_LOG_FORMAT = "%s : %s";
    private final String DASH = "-";

    public String formatCar(Car car) {
        return CAR_LOG_FORMAT
                .formatted(car.getName(), DASH.repeat(car.getLocation()));
    }

}
