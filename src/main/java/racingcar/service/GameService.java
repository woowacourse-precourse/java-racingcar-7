package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.RandomUtil;
import racingcar.validation.ProcessValid;

public class GameService {

    private Game game;

    public GameService(int playCount, List<Car> carList) {
        this.game = new Game(playCount, carList);
    }

    public List<Car> carProcess() {
        List<Car> carList = game.getCarList();
        for (Car car : carList) {
            increaseMove(car, RandomUtil.getRandomNumber());
        }
        return carList;
    }

    public void increaseMove(Car car, int randomNum) {
        if (ProcessValid.isRunCar(randomNum)) {
            car.move();
        }
    }

    public List<Car> determineWinners() {
        int maxDistance = game.getCarList().stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
        for (Car car : game.getCarList()) {
            if (car.getMoveCount() == maxDistance) {
                game.addWinner(car);
            }
        }
        return game.getWinnerList();
    }

}
