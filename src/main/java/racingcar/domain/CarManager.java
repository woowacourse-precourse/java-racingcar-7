package racingcar.domain;

import racingcar.util.ValidationUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.exception.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.exception.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;

public class CarManager {
    private List<Car> cars;
    public static int MIN_CAR_COUNT = 2;

    public CarManager(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(List<Integer> randomNumbers) {
        IntStream.range(0, cars.size())
                .forEach(i-> cars.get(i).move(randomNumbers.get(i)));
    }

    public List<String> findWinners(){
        return cars.stream()
                .filter(car -> car.getPosition() == findWinnerPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void validateCars(List<Car> cars){
        if(ValidationUtil.isMoreThanOne(cars)){
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }

        if(ValidationUtil.isDuplicate(cars)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}