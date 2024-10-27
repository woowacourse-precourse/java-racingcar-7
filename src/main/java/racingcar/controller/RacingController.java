package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    public void startRace() {
        List<String> cars = InputView.carNameInput();

        for(String s : cars) {
            System.out.println(s);
        }
    }
}
