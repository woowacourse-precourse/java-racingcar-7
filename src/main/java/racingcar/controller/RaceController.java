package racingcar.controller;

import racingcar.domain.CarRacing;

import static racingcar.controller.InputController.*;
import static racingcar.view.OutputView.*;

public class RaceController {

    private CarRacing carRacing;
    private int round;

    public void start() {
        set();
        play();
    }

    private void set() {
        carRacing = setCars();
        round = setRound();
    }

    private void play() {
        resultMessage();
        carRacing.raceRound(round);
        winnerMessage(carRacing.winnerList());
    }
}
