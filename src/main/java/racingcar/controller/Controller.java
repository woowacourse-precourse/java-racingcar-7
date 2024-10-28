package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.View;

public class Controller {
    public Controller(View view) {
        Racing racing = new Racing(view.inputNames(), view.inputRepeatCount(), view);
        racing.race();
    }
}
