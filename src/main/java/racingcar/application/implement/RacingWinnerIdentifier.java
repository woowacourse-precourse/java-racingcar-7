package racingcar.application.implement;

import java.util.List;
import racingcar.domain.CarRacer;

public class RacingWinnerIdentifier implements WinnerIdentifier<CarRacer> {

    @Override
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
