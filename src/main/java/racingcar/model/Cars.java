package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.CarsValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    public static final int RANDOM_MIN_NUMBER = 0;
    public static final int RANDOM_MAX_NUMBER = 9;
    public static final int SAME_POSITION = 0;
    public static final String WINNER_SEPARATION_COMMA = ", ";
    public static final int START_INDEX = 0;
    public static final int TRIM_END_INDEX = 2;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        CarsValidator.validateCars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(getPower());
        }
    }

    public int getPower() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }

    public Cars judgeWinnerCars() {
        Car maxPositionCar = findMaxPositionCar();
        cars.removeIf(car -> car.compareTo(maxPositionCar) != SAME_POSITION);
        return new Cars(cars);
    }

    private Car findMaxPositionCar() {
        Collections.sort(cars);
        return cars.getFirst();
    }

    public String getWinnersName() {
        List<String> winnersName = cars.stream().map(Car::getName).toList();
        return String.join(WINNER_SEPARATION_COMMA, winnersName);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}