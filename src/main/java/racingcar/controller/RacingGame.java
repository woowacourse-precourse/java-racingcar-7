package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.parser.InputParser;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final InputParser inputParser;
    private final OutputView outputView;

    public RacingGame(InputView inputView, InputParser inputParser, OutputView outputView) {
        this.inputView = inputView;
        this.inputParser = inputParser;
        this.outputView = outputView;
    }

    public void startRace() {
        List<Car> carList = creatCarListUsingGame(inputView.readRacingCarNames());
        int tryCount = getTryCount(inputView.readRacingTryCount());

        Game game = Game.carListFrom(carList);

        GameService gameService = new GameService(game, outputView);
        gameService.gameStart(tryCount);

        gameService.announceTheWinners();
    }

    private List<Car> creatCarListUsingGame(Input carNames) {
        return inputParser.parseRacingCarList(carNames);
    }

    private int getTryCount(Input tryCountString) {
        return inputParser.parseTryCount(tryCountString);
    }

}
