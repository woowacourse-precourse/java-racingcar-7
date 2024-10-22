package racingcar.controller;

import racingcar.handler.PrintHandler;

public class Controller {
    private final PrintHandler printHandler;


    public Controller() {
        this.printHandler = new PrintHandler();
    }

    public void run () {
        printHandler.racingStartMessage();

    }
}
