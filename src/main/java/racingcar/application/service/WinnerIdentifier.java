package racingcar.application.service;

import java.util.List;
import racingcar.racing.RacingCar;

public class WinnerIdentifier {

    public List<RacingCar> identify(List<RacingCar> racedCars) {
        int maxProgress = getMaxProgress(racedCars);

        return racedCars.stream()
                .filter(car -> car.getProgressState().length() == maxProgress)
                .toList();
    }

    private int getMaxProgress(List<RacingCar> racedCars) {
        return racedCars.stream()
                .mapToInt(car -> car.getProgressState().length())
                .max()
                .getAsInt();
    }
}
