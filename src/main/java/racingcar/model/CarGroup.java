package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> racingCarList;

    public CarGroup(String[] carList) {
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carList) {
            validateCarName(carName);
            Car car = new Car(carName);
            carGroup.add(car);
        }
        this.racingCarList = List.copyOf(carGroup);
    }

    private void validateCarName(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름의 길이는 0이 될 수 없습니다.");
        }
    }

    public List<Car> getCarList() {
        return racingCarList;
    }

    public void go() {
        for (Car car : racingCarList) {
            car.drive();
        }
    }

    public int calculateMaxScore() {
        int maxScore = 0;
        for (Car car : racingCarList) {
            int i = car.getScore();
            if (maxScore < i) {
                maxScore = i;
            }
        }
        return maxScore;
    }

    public List<String> getWinnerCarList() {
        int maxScore = calculateMaxScore();
        List<String> winnerCarList = new ArrayList<>();
        for (Car car : racingCarList) {
            if (car.getScore() == maxScore) {
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }
}
