package racingcar.controller;

import racingcar.domain.Car;
import racingcar.parser.InputParser;
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
        String turns = inputView.InputTurns();
        return InputParser.parseTurns(turns);
    }

    private void initializeCars(){
        String names = inputView.InputNames();
        List<String> nameList = InputParser.parseNames(names);
        carService.initCars(nameList);
    }
    

}
