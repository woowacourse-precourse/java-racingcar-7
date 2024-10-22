package racingcar.game;

import racingcar.count.CountService;
import racingcar.car.Car;
import racingcar.car.CarInputService;
import racingcar.utils.IOUtils;
import racingcar.utils.StringUtils;

import java.util.List;

public class Game {
    CarInputService carInputService;
    CountService countService;
    GameView gameView;

    public Game(CarInputService carInputService, CountService countService, GameView gameView) {
        this.carInputService = carInputService;
        this.countService = countService;
        this.gameView = gameView;
    }

    public void run() {
        List<Car> cars = carInputService.getCars();
        int attemptCount = StringUtils.convertStringToInteger(countService.getAttemptCount());
        IOUtils.outputStringWithEnter("");
    }
}
