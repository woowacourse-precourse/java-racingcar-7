package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {
    private InputView inputView;
    // start: singleton holer
    private RacingcarController() {
        inputView = new InputView();
    }

    private static class InnerRacingcarController {
        private static final RacingcarController INSTANCE = new RacingcarController();
    }

    public static RacingcarController getInstance() {
        return InnerRacingcarController.INSTANCE;
    }
    // end: singleton holer

    public void playGame() {
        printMenu();
        inputView.requestInputCarName();
    }

    private void printMenu() {

    }
}
