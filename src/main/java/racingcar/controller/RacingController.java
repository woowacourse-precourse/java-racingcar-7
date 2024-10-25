package racingcar.controller;

import java.util.Arrays;
import racingcar.view.InputView;

public class RacingController {
    public void start() {
        String[] carNames = InputView.getCarNames();
        System.out.println(Arrays.toString(carNames));

        int tryTime = InputView.getTryTime();
        System.out.println(tryTime);
    }
}
