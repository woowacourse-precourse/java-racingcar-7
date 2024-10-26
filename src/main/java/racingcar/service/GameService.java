package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.helper.util.RandomUtil;
import racingcar.helper.validation.ProcessValid;

public class GameService {

    private Game game;

    public GameService(int playCount, List<Car> carList) {
        this.game = new Game(playCount, carList);
    }

    public int getPlayCount() {
        return game.getPlayCount();
    }

    public List<Car> carProcess() {
        List<Car> carList = game.getCarList();
        for (Car car : carList) {
            increaseMove(car, RandomUtil.getRandomNumber());
        }
        return game.getCarList();
    }

    public void increaseMove(Car car, int randomNum) {
        if (ProcessValid.isRunCar(randomNum)) {
            car.move();
        }
    }

    public List<Car> determineWinners() {
        int maxDistance = getMaxDistance();
        for (Car car : game.getCarList()) {
            if (car.getMoveCount() == maxDistance) {
                game.addWinner(car);
            }
        }
        return game.getWinnerList();
    }

    public int getMaxDistance() {
        return game.getCarList().stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

}
