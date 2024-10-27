package racingcar.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.service.RacingCarService;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarServiceImpl implements RacingCarService {
    private List<Car> cars;
    private Integer attemptCount;
    private static final Integer RANDOM_NUMBER_MIN = 0;
    private static final Integer RANDOM_NUMBER_MAX = 9;
    private static final String NO_WINNER_ERROR_MESSAGE = "우승자가 존재하지 않습니다.";

    public RacingCarServiceImpl(List<Car> cars, Integer attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    @Override
    public void startRace() {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                Integer randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
                printRacing(car, randomNumber);
            }
            System.out.println();
        }
    }

    @Override
    public String getWinner() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NO_WINNER_ERROR_MESSAGE));

        if (maxDistance == 0) {
            throw new IllegalArgumentException(NO_WINNER_ERROR_MESSAGE);
        }
        
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public void printRacing(Car car, Integer randomNumber) {
        if (randomNumber >= 4) {
            car.setDistance();
        }
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
}