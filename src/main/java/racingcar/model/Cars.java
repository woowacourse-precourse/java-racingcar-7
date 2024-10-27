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
            addCarIfTopPosition(winners, car, topPosition);
        }
        return winners;
    }

    private void addCarIfTopPosition(List<Car> winners, Car car, int topPosition) {
        if (car.getPosition() == topPosition) {
            winners.add(car);
        }
    }

    private int findTopPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = updateMaxPosition(maxPosition, car);
        }
        return maxPosition;
    }

    private int updateMaxPosition(int currentMax, Car car) {
        if (car.getPosition() > currentMax) {
            return car.getPosition();
        }
        return currentMax;
    }


    public List<Car> getCarList() {
        return carList;
    }

}
