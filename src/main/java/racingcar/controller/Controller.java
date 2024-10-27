package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RaceService;

import java.util.List;

public class Controller {

    private final RaceService raceService = new RaceService();

    public void run() {
        List<Car> carList = raceService.createCarList();
        int tryCnt = raceService.getTryCount();

        // 테스트용
        for (Car car : carList) {
            System.out.println(car.getName());
        }
        System.out.println("시도할 횟수: " + tryCnt);
    }
}
