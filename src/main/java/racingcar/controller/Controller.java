package racingcar.controller;

import java.util.Arrays;
import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;

public class Controller {
    private final PrintHandler printHandler;
    private final InputHandler inputHandler;

    public Controller() {
        this.printHandler = new PrintHandler();
        this.inputHandler = new InputHandler();
    }

    public void run () {
        printHandler.racingStartMessage();
        String [] tempCarNames = inputHandler.inputCarNames();
    }
}
