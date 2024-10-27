package racingcar.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.utils.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameService {
    private final CarService carService = new CarService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public GameData getGameData() throws IOException {
        String carsName = inputView.getCarNames();
        List<Car> cars = carService.createCars(carsName);

        int attempts = inputView.getTryNumbers();
        return new GameData(cars, attempts);
    }

    public void playGame(GameData gameData) {
        for (int i = 0; i < gameData.getAttempts(); i++) {
            for (Car car : gameData.getCars()) {
                car.move(Util.generateRandomNumber());
            }
        }
    }

    public void announceWinners(List<Car> winnerCars) {
        List<String> winners = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        outputView.printWinners(winners);
    }

}
