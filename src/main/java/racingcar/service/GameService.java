package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameService {
    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;
    private final GameEngine gameEngine;

    public GameService(CarService carService, InputView inputView, OutputView outputView, GameEngine gameEngine) {
        this.carService = carService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameEngine = gameEngine;
    }

    public GameData initializeGame() {
        String carsName = inputView.getCarNames();
        List<Car> cars = carService.createCars(carsName);
        int attempts = inputView.getTryNumbers();

        return new GameData(cars, attempts);
    }

    public void startGame(GameData gameData) {
        for (int i = 0; i < gameData.getAttempts(); i++) {
            gameEngine.playTurn(gameData.getCars());
            outputView.printStatus(gameData.getCars());
        }
    }

    public void announceWinners(GameData gameData) {
        List<Car> winnerCars = gameEngine.determineWinners(gameData.getCars());
        List<String> winnerNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        outputView.printWinners(winnerNames);
    }
}
