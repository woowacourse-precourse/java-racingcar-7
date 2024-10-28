package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {
    private List<Car> carList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();

    public void prepareCars(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public void startRace() {
        for (Car car : carList) {
            car.move();
        }
    }

    public void findWinners() {
        int maxDistance = findMaxDistance();

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winnerList.add(car.getName());
            }
        }
    }

    private int findMaxDistance() {
        int maxDistance = 0;

        for (Car car : carList) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
}
