package racingcar.domain;

import java.util.List;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

public class Game {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private Cars cars;
    private Rounds rounds;

    public Game(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        List<String> carNames = inputHandler.getCarNames();
        cars = new Cars(carNames);

        String roundSizeInput = inputHandler.getRoundSize();
        rounds = new Rounds(roundSizeInput);

        outputHandler.printResultMessage();
        rounds.proceedRounds(cars.getCars(), outputHandler);

        List<String> winners = cars.getWinners();
        outputHandler.printWinner(winners);
    }
}
