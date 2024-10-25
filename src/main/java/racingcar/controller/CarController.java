package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {
    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController(CarService carService, InputView inputView, OutputView outputView) {
        this.carService = carService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeCars();

        int turns = getTurns();
        startGames(turns);

        exitGame();
    }

    private void exitGame() {
        List<String> winners = carService.getWinners();
        outputView.printWinners(winners);
    }

    private void startGames(int number) {
        outputView.startPlay();

        while (number-- > 0) {
            List<Car> cars = carService.playRound();
            outputView.printPlayRoundResult(cars);
        }
    }

    private int getTurns() {
        return inputView.InputTurns();
    }

    private void initializeCars(){
        List<String> nameList = inputView.InputNames();
        carService.initCars(nameList);
    }
    

}
