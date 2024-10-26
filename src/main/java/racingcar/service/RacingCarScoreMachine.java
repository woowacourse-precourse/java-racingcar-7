package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberMaker;

//fixme RaceService
public class RacingCarScoreMachine {
    private final Cars cars;
    private final AttemptCounter attemptCounter;


    private final NumberMaker randomNumberMaker;
    private final static int FORWARDABLE_MIN_RANDOM_CRITERIA = 4;
    private final static int FORWARD_DISTANCE = 1;


    public RacingCarScoreMachine(Cars cars, AttemptCounter attemptManager, NumberMaker randomNumberMaker) {
        this.cars = cars;
        this.attemptCounter = attemptManager;
        this.randomNumberMaker = randomNumberMaker;
    }

    public boolean isOverRace() {
        return attemptCounter.isEndAttempt();
    }

    public void runRace() {
        for (Car car : cars.getCars()) {
            int randomNumber = randomNumberMaker.make();
            if (randomNumber >= FORWARDABLE_MIN_RANDOM_CRITERIA) {
                car.updateDistance(FORWARD_DISTANCE);
            }
        }
        attemptCounter.decrease();
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
