package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarGameManager;

public class CarService {
    public Car car;
    public CarGameManager carGameManager;

    public CarService(CarGameManager carGameManager) {
        this.carGameManager = carGameManager;
    }

    public void start(String[] names, int times) {
        carGameManager.start(names, times);
    }

    public List<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int max = 0;
        List<Integer> eachCarResultDistance = carGameManager.getEachCarResultDistance();

        for (Integer distance : eachCarResultDistance) {
            if (distance >= max) {
                max = distance;
            }
        }

        for (int i = 0; i < carGameManager.getTotalCars(); i++) {
            if(eachCarResultDistance.get(i) == max) {
                winners.add(carGameManager.getCars().get(i).getName());
            }
        }
        return winners;
    }
}
