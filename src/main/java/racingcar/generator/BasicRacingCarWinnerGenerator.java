package racingcar.generator;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class BasicRacingCarWinnerGenerator implements RacingCarWinnerGenerator {
    @Override
    public List<Car> generateWinner(List<Car> racingCars) {
        int maxLocation = getMaxLocation(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.getCurrentLocation() == maxLocation)
                .collect(Collectors.toList());
    }

    private int getMaxLocation(List<Car> racingCars) {
        int max = 0;
        for (Car racingCar : racingCars) {
            max = Math.max(max, racingCar.getCurrentLocation());
        }
        return max;
    }
}
