package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.CarList;

public class CarService {
    private final CarList carList;

    public CarService(CarList carList) {
        this.carList = carList;
    }

    public void runRoundGame() {
        for (Car car : carList.getCars()) {
            if (isFastForward()) {
                car.addDistance();
            }
        }
    }

    public boolean isFastForward() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    public List<String> getWinners() {

        int winnerDistance = getMaxDistance();

        List<String> winners = new ArrayList<>();
        for (Car car : carList.getCars()) {
            if (car.getDistance() == winnerDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : carList.getCars()) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }
}
