package racingcar.application.service;

import java.util.List;
import racingcar.racing.CarRacer;

public class WinnerIdentifier {

    public List<CarRacer> identify(List<CarRacer> racedCars) {
        int maxProgress = getMaxProgress(racedCars);

        return racedCars.stream()
                .filter(car -> car.getProgressState().length() == maxProgress)
                .toList();
    }

    private int getMaxProgress(List<CarRacer> racedCars) {
        return racedCars.stream()
                .mapToInt(car -> car.getProgressState().length())
                .max()
                .getAsInt();
    }
}
