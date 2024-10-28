package racingcar.model;

import racingcar.controller.RacingController;
import racingcar.view.inputView.CarNameInputView;
import racingcar.view.inputView.MoveCountInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController();

        racingController.startRacing();
    }
}
