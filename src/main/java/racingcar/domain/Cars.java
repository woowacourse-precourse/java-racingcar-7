package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.exception.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.exception.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.util.ValidationUtil.isDuplicate;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    public static int MIN_CAR_COUNT = 2;

    public Cars(List<String> carNames) {
        validateCarNames(carNames);
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getCarsSize(){
        return cars.size();
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
        if(carNames.size() < MIN_CAR_COUNT){
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }

        if(isDuplicate(carNames)){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}