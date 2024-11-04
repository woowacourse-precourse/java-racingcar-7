package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.model.RacingInfo;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView.receiveUserInput();

        RacingInfo.initialize(); // RacingInfo 초기화 진행

        RacingcarController controller = new RacingcarController();
        controller.race();
    }
}
