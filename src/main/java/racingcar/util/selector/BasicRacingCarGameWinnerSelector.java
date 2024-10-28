package racingcar.util.selector;

import java.util.List;
import racingcar.domain.RacingCar;

public class BasicRacingCarGameWinnerSelector implements RacingCarGameWinnerSelector {
    @Override
    public List<RacingCar> generateWinner(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocation(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.getCurrentLocation() == maxLocation)
                .toList();
    }

    private int getMaxLocation(List<RacingCar> racingCars) {
        int max = 0;
        for (RacingCar racingCar : racingCars) {
            max = Math.max(max, racingCar.getCurrentLocation());
        }
        return max;
    }
}
