package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RaceService {

    public static final int CAR_MAX_SCOPE = 100;
    public static final int CAR_FORWARD_CONDITION = 4;

    public List<Car> carListOf(String userInput) {
        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            if (!cars.isEmpty()) {
                validateSameNameIn(cars, carName);
            }

            cars.add(Car.from(carName));
        }

        validateExistCarInList(cars);
        validateCarListLessThenMaxLength(cars);
        return cars;
    }

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxLocation == car.location()) {
                winnersName.add(car.name());
            }
        }
        return winnersName;
    }

    public void forwardWithRandomCondition(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= CAR_FORWARD_CONDITION) {
                car.forward();
            }
        }
    }

    private int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.location(), maxLocation);
        }
        return maxLocation;
    }

    private void validateSameNameIn(List<Car> cars, String carName) {
        for (Car car : cars) {
            if (car.name().equals(carName)) {
                throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
            }
        }
    }

    private void validateCarListLessThenMaxLength(List<Car> cars) {
        if (cars.size() > CAR_MAX_SCOPE) {
            throw new IllegalArgumentException("자동차는 최대 " + CAR_MAX_SCOPE + "개까지 입력 가능합니다.");
        }
    }

    private void validateExistCarInList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }
}
