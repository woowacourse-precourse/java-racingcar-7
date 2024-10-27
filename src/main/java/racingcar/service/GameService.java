package racingcar.service;

import java.io.IOException;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.utils.Util;
import racingcar.view.InputView;

public class GameService {
    private final CarService carService = new CarService();
    private final InputView inputView = new InputView();

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

}
