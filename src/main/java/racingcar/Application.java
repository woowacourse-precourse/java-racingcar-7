package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        RacingController racingController = new RacingController(inputView);

        racingController.startRacing();
    }
}
