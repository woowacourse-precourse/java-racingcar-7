package racingcar.domain;

import racingcar.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.exception.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.exception.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    public static int MIN_CAR_COUNT = 2;

    public Cars(List<String> carNames) {
        validateCarNames(carNames);
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
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

    private void validateCarNames(List<String> carNames){
        if(!ValidationUtil.isMoreThanOne(carNames)){
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }

        if(ValidationUtil.isDuplicate(carNames)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}