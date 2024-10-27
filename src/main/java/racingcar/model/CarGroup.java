package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exceptions.RacingCarExceptionHandler;
import racingcar.exceptions.RacingCarExceptionMessage;

public class CarGroup {
    private final List<Car> racingCarList;

    public CarGroup(String[] carList) {
        if(carList==null){
            throw new IllegalArgumentException(RacingCarExceptionMessage.CAR_NAME_CANNOT_BE_NULL.getText());
        }
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carList) {
            Car car = new Car(carName);
            carGroup.add(car);
        }
        this.racingCarList = List.copyOf(carGroup);
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
