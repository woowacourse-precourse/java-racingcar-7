package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    private final List<String> winners = new ArrayList<>();
    private final CarList carList = new CarList(new ArrayList<>());

    public void determineWinner() {
        int maxMoved = getMaxMoved();
        for (Car car : carList.getCars()) {
            if (car.getCarMoved() == maxMoved) {
                winners.add(car.getCarName());
            }
        }
    }

    public int getMaxMoved() {
        int maxMoved = 0;
        for (Car car : carList.getCars()) {
            maxMoved = Math.max(maxMoved, car.getCarMoved());
        }
        return maxMoved;
    }

    public List<String> getWinners() {
        return winners;
    }
}
