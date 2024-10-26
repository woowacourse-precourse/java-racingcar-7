package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createCarList(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> carList = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            String carName = name.trim();

            if (uniqueNames.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + carName);
            }
            uniqueNames.add(carName);

            carList.add(new Car(carName));
        }

        return new Cars(carList);
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
