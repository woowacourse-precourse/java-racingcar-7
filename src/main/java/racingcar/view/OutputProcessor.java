package racingcar.view;

import java.util.stream.Collectors;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputProcessor {

    public String formatCars(Cars cars) {
        return cars.getCars().stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getDistance()))
                .collect(Collectors.joining("\n")) + "\n";
    }

    public String formatWinners(Winners winners) {
        return Message.FINAL_WINNER + winners.getWinnerNames();
    }
}
