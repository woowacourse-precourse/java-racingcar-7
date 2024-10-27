package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.number.NumberMaker;

public class RaceService {
    private final static int CAN_MOVE_MIN_RANDOM_CRITERIA = 4;
    private final static int MOVE_DISTANCE = 1;
    private final AttemptCounter attemptCounter;
    private final Cars cars;
    private final NumberMaker randomNumberMaker;

    public RaceService(AttemptCounter attemptManager, Cars cars, NumberMaker randomNumberMaker) {
        this.attemptCounter = attemptManager;
        this.cars = cars;
        this.randomNumberMaker = randomNumberMaker;
    }

    public boolean isEndRace() {
        return attemptCounter.isEndAttempt();
    }

    public void runRace() {
        tryMove();
        attemptCounter.decrease();
    }

    private void tryMove() {
        for (Car car : cars.getCars()) {
            int randomNumber = randomNumberMaker.make();
            if (randomNumber >= CAN_MOVE_MIN_RANDOM_CRITERIA) {
                car.updateDistance(MOVE_DISTANCE);
            }
        }
    }


    public Set<Car> getCarsNameAndDistance() {
        return cars.getCars();
    }

    public List<String> getWinningCarsNames() {
        List<String> result = new ArrayList<>();
        for (Car car : cars.getWinningCar()) {
            result.add(car.getName());
        }
        return result;
    }

}
