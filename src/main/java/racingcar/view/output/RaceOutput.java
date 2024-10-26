package racingcar.view.output;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RaceOutput {
    public static String getProgress(Race race) {
        StringBuilder output = new StringBuilder();

        for (Car car : race.getCars()) {
            output.append(car.getName()).append(" : ");
            output.append("-".repeat(car.getPosition()));
            output.append("\n");
        }

        return output.toString();
    }
}