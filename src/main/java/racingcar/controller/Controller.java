package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.CarsDto;
import racingcar.service.CarService;
import racingcar.utils.Utils;
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
        List<CarsDto> raceResults = IntStream.range(Utils.ZERO, times)
                .mapToObj(i -> carService.moveAllCars())
                .map(CarsDto::new)
                .toList();
        view.outputRaceResults(raceResults);
    }

    private void getWinners() {
        List<String> winners = carService.getCarsWithMaxDistance();
        view.outputFinalWinner(winners);
    }

}
