package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;

public class Controller {

    private final InputView input;

    public Controller() {
        input = new InputView();
    }

    public void run() {
        String players = input.readPlayers();
        int count = input.readCount();
        new RacingCar(players, count);
    }
}
