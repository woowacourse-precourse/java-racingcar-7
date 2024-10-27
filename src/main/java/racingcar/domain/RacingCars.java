package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> cars;
    private Integer currentAttempts;
    private final Integer totalAttempts;
    private static final Integer INITIAL_CURRENT_ATTEMPTS = 0;

    private RacingCars(Integer totalAttempts) {
        this.cars = new ArrayList<>();
        this.currentAttempts = INITIAL_CURRENT_ATTEMPTS;
        this.totalAttempts = totalAttempts;
    }

    private List<RacingCar> getCars() {
        return cars;
    }

    public static RacingCars createRacingCars(List<String> carNames, Integer totalAttempts) {
        RacingCars racingCars = new RacingCars(totalAttempts);
        for (String carName : carNames) {
            racingCars.cars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public List<RacingCar> attempt() {
        for (RacingCar car : cars) {
            car.tryToAdvance();
        }
        return getCars();
    }
}
