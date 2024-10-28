package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameRule;
import racingcar.domain.RacingGame;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private Validator validator = new Validator();
    private GameService gameService = new GameService();

    public List<String> getCarNames() {
        InputView.carNamesMessage();
        String carNames = Console.readLine();
        return validator.validateCarName(carNames);
    }

    public int getGameCount() {
        InputView.gameCountMessage();
        String gameCountString = Console.readLine();
        int gameCount = Integer.parseInt(gameCountString);
        return validator.validateGameCount(gameCount);
    }

    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (String name : getCarNames()) {
            cars.add(gameService.createCar(name));
        }
        return cars;
    }

    public GameRule setGameCount() {
        return gameService.determineGameCount(getGameCount());
    }

    public void gameStart() {
        RacingGame racingGame = gameService.readyRacingGame(createCars(), setGameCount());
        OutputView.resultMessage();
        gameService.play(racingGame);
        OutputView.printWinnerName(gameService.getWinnerCarName(racingGame));
    }

}
