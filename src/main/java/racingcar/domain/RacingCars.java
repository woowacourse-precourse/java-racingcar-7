package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> cars;
    private Integer currentAttempts;
    private final Integer totalAttempts;
    private List<RacingCar> winners;
    private static final Integer INITIAL_CURRENT_ATTEMPTS = 0;

    private RacingCars(Integer totalAttempts) {
        this.cars = new ArrayList<>();
        this.currentAttempts = INITIAL_CURRENT_ATTEMPTS;
        this.totalAttempts = totalAttempts;
        this.winners = new ArrayList<>();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public Integer getTotalAttempts() {
        return totalAttempts;
    }

    public Integer getCurrentAttempts() {
        return currentAttempts;
    }

    private List<RacingCar> getWinners() {
        return winners;
    }

    public static RacingCars createRacingCars(List<String> carNames, Integer totalAttempts) {
        RacingCars racingCars = new RacingCars(totalAttempts);
        for (String carName : carNames) {
            racingCars.cars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public List<RacingCar> attempt() {
        cars.forEach(RacingCar::tryToAdvance);
        increaseCurrentAttempts();
        return getCars();
    }

    private void increaseCurrentAttempts() {
        currentAttempts++;
    }

    public List<RacingCar> findWinners() {
        Integer maxAdvanceCount = getMaxAdvanceCount();
        return cars.stream()
                .filter(car -> car.getAdvanceCount().equals(maxAdvanceCount))
                .collect(Collectors.toList());
    }

    private Integer getMaxAdvanceCount() {
        return cars.stream()
                .mapToInt(RacingCar::getAdvanceCount)
                .max()
                .orElse(0);
    }

    public boolean isNotEnoughAttempts() {
        return currentAttempts < totalAttempts;
    }
}
