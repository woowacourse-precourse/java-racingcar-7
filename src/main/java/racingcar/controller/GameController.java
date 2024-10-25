package racingcar.controller;

import racingcar.view.InputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        recruitParticipants();
    }

    private static void recruitParticipants() {
        ArrayList<String> carNames = InputView.getCarNames();
    }

}
