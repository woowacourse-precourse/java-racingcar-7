package racingcar.game;

import racingcar.car.Car;
import racingcar.car.CarInputService;
import racingcar.count.CountInputService;
import racingcar.utils.IOUtils;
import racingcar.utils.StringUtils;

import java.util.List;

public class Game {
    CarInputService carInputService;
    CountInputService countInputService;
    GameService gameService;
    GameView gameView;

    public Game(
            CarInputService carInputService,
            CountInputService countInputService,
            GameService gamerService,
            GameView gameView) {
        this.carInputService = carInputService;
        this.countInputService = countInputService;
        this.gameService = gamerService;
        this.gameView = gameView;
    }

    public void run() {
        List<Car> cars = carInputService.getCars();
        int attemptCount = StringUtils.convertStringToInteger(countInputService.getAttemptCount());
        IOUtils.outputStringWithEnter("");

        processingGame(cars, attemptCount);
    }

    private void processingGame(List<Car> cars, int attemptCount) {
        IOUtils.outputStringWithEnter("실행 결과");

        while (attemptCount > 0) {
            gameService.moveEachCars(cars);
            attemptCount--;
            gameView.printMove(cars);
        }

        gameView.printWinner(cars);
    }
}
