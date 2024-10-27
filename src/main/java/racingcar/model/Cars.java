package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.move.RandomStrategy;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNames) {
        if (!validateCarName(carNames)) {
            throw new IllegalArgumentException("자동차의 이름이 올바르지 않습니다.");
        }

        this.cars = createCar(carNames);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> createCar(final String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName, new RandomStrategy()));
        }

        return carList;
    }

    private boolean validateCarName(final String[] carNames) {
        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public List<String> findWinner() {
        int maxPosition = -1;
        List<String> nameList = new ArrayList<>();

        for (Car car : cars) {
            int curPosition = car.getPosition();
            if (curPosition > maxPosition) {
                maxPosition = curPosition;
                nameList.clear();
                nameList.add(car.getName());
            } else if (curPosition == maxPosition) {
                nameList.add(car.getName());
            }
        }

        return nameList;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
