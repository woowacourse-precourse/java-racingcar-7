package racingcar.game.model;

import java.util.*;

import static racingcar.game.constant.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.game.constant.ExceptionMessage.INVALID_CAR_COUNT;

public class CarGroup {
    private List<Car> cars = new ArrayList<>();
    private Integer carCountLimit = 10;
    public void addCars(List<String> carNameList) {
        validateCarCount(carNameList);
        for (String carName : carNameList) {
            checkDuplicateCarName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        List<Integer> carsPosition = new ArrayList<>();
        for(Car car : cars) carsPosition.add(car.getPosition());

        int maxPosition = Collections.max(carsPosition);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private void validateCarCount(List<String> carNameList) {
        if(carCountLimit< carNameList.size())
            throw new IllegalArgumentException(INVALID_CAR_COUNT.getMessage());
    }

    private void checkDuplicateCarName(String carName) {
        for (Car car : cars) {
            if (car.getName().equals(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }
}
