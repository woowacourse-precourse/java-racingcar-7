package racingcar.util.selector;

import java.util.List;
import racingcar.domain.RacingCar;

public class BasicRacingCarGameWinnerSelector implements RacingCarGameWinnerSelector {
    @Override
    public List<RacingCar> selectWinner(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocation(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.getCurrentLocation() == maxLocation)
                .toList();
    }

    private int getMaxLocation(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToInt(racingCar -> racingCar.getCurrentLocation())
                .max().getAsInt();
    }
}
