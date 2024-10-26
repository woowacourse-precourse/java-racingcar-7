package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.global.message.ErrorMessage;
import racingcar.global.utils.ParseStringUtils;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createCarList(String carNamesInput) {
        List<String> carNames = ParseStringUtils.splitCarNames(carNamesInput);
        List<Car> carList = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carNames) {
            addUniqueCarToList(carList, uniqueNames, carName);
        }

        return new Cars(carList);
    }

    private static void addUniqueCarToList(List<Car> carList, Set<String> uniqueNames, String carName) {
        if (uniqueNames.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage() + ": " + carName);
        }
        uniqueNames.add(carName);
        carList.add(new Car(carName));
    }


    public void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<Car> findWinnerCars() {
        int topPosition = findTopPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == topPosition) {
                winners.add(car);
            }
        }
        return winners;

    }

    private int findTopPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }


    public List<Car> getCarList() {
        return carList;
    }

}
