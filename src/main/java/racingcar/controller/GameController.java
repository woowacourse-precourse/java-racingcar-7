package racingcar.controller;

import racingcar.service.Separation;
import racingcar.view.View;

public class GameController {
    private final View view;
    private final Separation separation;

    public GameController() {
        this.view = new View();
        this.separation = new Separation();
    }

    public void run() {
        view.Message();
        String userInput = view.userInput();

        String[] splitUserInput = separation.split(userInput);
    }
}
