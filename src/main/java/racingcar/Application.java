package racingcar;

import racingcar.controller.ApplicationController;
import racingcar.view.ViewInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationController applicationController = new ApplicationController(
            new ViewInput()
        );
        applicationController.run();

    }
}
