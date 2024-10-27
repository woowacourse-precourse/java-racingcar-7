package racingcar.controller;

import racingcar.service.Separation;
import racingcar.view.View;
import racingcar.service.Verification;

public class GameController {
    private final View view;
    private final Separation separation;
    private final Verification verification;

    public GameController() {
        this.view = new View();
        this.separation = new Separation();
        this.verification = new Verification();
    }

    public void run() {
        view.Message();
        String userInput = view.userInput();
        verification.special_characters(userInput);

        String[] splitUserInput = separation.split(userInput);

    }
}
