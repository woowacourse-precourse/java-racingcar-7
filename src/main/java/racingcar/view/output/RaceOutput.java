package racingcar.view.output;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RaceOutput {
    public static String getProgress(Race race) {
        StringBuilder output = new StringBuilder();
        for (Car car : race.getCars()) {
            output.append(car.getName()).append(OutputMessages.CAR_PROGRESS_SEPARATOR);
            output.append(OutputMessages.CAR_POSITION_MARKER.repeat(car.getPosition()));
            output.append(OutputMessages.NEW_LINE);
        }
        return output.toString();
    }
}