package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RaceService;

import java.util.List;

public class Controller {

    private final RaceService raceService = new RaceService();

    public void run() {
        List<Car> carList = raceService.createCarList();
        int tryCnt = raceService.getTryCount();
        System.out.println();

        // 경주 시작
        raceService.startRace(carList, tryCnt);
    }
}
