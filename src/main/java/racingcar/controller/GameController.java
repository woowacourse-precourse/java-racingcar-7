package racingcar.controller;

import racingcar.model.*;
import racingcar.model.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputExtractor inputExtractor;

    public GameController(InputView inputView, OutputView outputView, InputExtractor inputExtractor) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputExtractor = inputExtractor;
    }

    public void start() {
        inputView.printCarNameRequestMessage();
        List<Car> cars = makeCars();
        inputView.printTryCntRequestMessage();
        int rounds = Integer.parseInt(inputView.getTryCnt());

        Game game = new Game(cars, new Referee(), new RandomNumberGenerator());
        while (rounds > 0) {
            game.playOneRound();
            outputView.printRoundResult(game.getCars());
            rounds--;
        }
        outputView.printFinalResult(game.getWinners());
    }

    private List<Car> makeCars() {
        return inputExtractor.extractCars(inputView.getCarNames());
    }
}
