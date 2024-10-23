package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.View;

public class Controller {

    private final View view;
    private final CarService carService;

    public Controller(View view, CarService carService) {
        this.view = view;
        this.carService = carService;
    }

    public void run() {
        makeCars();
        playGame();
        getWinners();
    }

    private void makeCars() {
        String[] names = view.inputNames();
        for (String name : names) {
            carService.addCar(name);
        }
    }

    private void playGame() {
        int times = view.inputTimes();
        List<List<Car>> raceResults = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            List<Car> oneRoundResult = carService.moveAllCars();
            raceResults.add(oneRoundResult);
        }
        view.outputRaceResults(raceResults);
    }

    private void getWinners() {
        List<String> winners = carService.getCarsWithMaxDistance();
        view.outputFinalWinner(winners);
    }

}
