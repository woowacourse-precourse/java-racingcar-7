package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Race;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;

public class RaceController {

    public void run() {
        ArrayList<String> carNames = InputView.readCarNames();
        int repeatCount = InputView.readRepeatCount();
        Race race = new Race(carNames,new RandomNumberGenerator());

    }
}
