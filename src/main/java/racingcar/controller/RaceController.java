package racingcar.controller;

import racingcar.view.View;
import racingcar.domain.*;

public class RaceController {
    public void startRace() {
        Cars cars = Cars.saveNames(View.requestCarNames());
    }
}