package racingcar.util.generator;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class BasicRacingCarWinnerGenerator implements RacingCarWinnerGenerator {
    @Override
    public List<RacingCar> generateWinner(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocation(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.getCurrentLocation() == maxLocation)
                .collect(Collectors.toList());
    }

    private int getMaxLocation(List<RacingCar> racingCars) {
        int max = 0;
        for (RacingCar racingCar : racingCars) {
            max = Math.max(max, racingCar.getCurrentLocation());
        }
        return max;
    }
}
