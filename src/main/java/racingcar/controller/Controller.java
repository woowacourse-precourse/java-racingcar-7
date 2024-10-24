package racingcar.controller;

import java.util.List;
import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;
import racingcar.model.Car.Cars;
import racingcar.model.Referee;

public class Controller {
    private final PrintHandler printHandler;
    private final InputHandler inputHandler;

    public Controller() {
        this.printHandler = new PrintHandler();
        this.inputHandler = new InputHandler();
    }

    public void run() {
        printHandler.racingStartMessage();
        String[] tempCarNames = inputHandler.inputCarNames();
        Cars cars = new Cars(tempCarNames);

        printHandler.racingNumberMessage();
        int gameNumber = inputHandler.inputGameNumber();
        Referee referee = new Referee(cars);

        printHandler.racingResultStartMessage();
        for (int i = 0; i < gameNumber; i++) {
            referee.playRound();
            printHandler.printCurrentPositions(referee.getCarNames(), referee.getCarPositions());
        }

        List<String> winners = referee.getWinners();
        printHandler.printWinners(winners);
    }
}
