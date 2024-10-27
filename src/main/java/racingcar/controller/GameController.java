package racingcar.controller;

import racingcar.view.View;
;
public class GameController {
    private final View view;

    public GameController() {
        this.view = new View();
    }

    public void run() {
        view.Message();
        String userInput = view.userInput();
    }
}
