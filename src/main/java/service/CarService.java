package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.CarList;

public class CarService {
    private CarList carList;

    public CarService() {
        carList = new CarList();
    }

    public CarService(CarList carList) {
        this.carList = carList;
    }

    public boolean isCarExist(String newCarName) {
        for (Car car : carList.getCars()) {
            String existingName = car.getName();
            if (existingName.equals(newCarName)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateCarName(String newCarName) {
        if (newCarName.isBlank()) {
            return false;
        }

        if (!isCarExist(newCarName)) {
            int carNameLength = newCarName.length();
            return carNameLength > 0 && carNameLength <= 5;
        }
        return false;
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
