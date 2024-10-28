package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.utils.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameService {
    private final CarService carService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameService(CarService carService, InputView inputView, OutputView outputView) {
        this.carService = carService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public GameData getGameData() throws IOException {
        String carsName = inputView.getCarNames();
        List<Car> cars = carService.createCars(carsName);
        int attempts = inputView.getTryNumbers();
        System.out.println();
        System.out.println("실행 결과");
        Console.close();
        return new GameData(cars, attempts);
    }

    public void playGame(GameData gameData) {
        for (int i = 0; i < gameData.getAttempts(); i++) {
            playTurn(gameData.getCars());
            outputView.printStatus(gameData.getCars());
        }
    }

    private void playTurn(List<Car> cars) {
        for (Car car : cars) {
            car.move(Util.generateRandomNumber());
        }
    }

    public void announceWinners(List<Car> winnerCars) {
        List<String> winners = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        outputView.printWinners(winners);
    }
}
