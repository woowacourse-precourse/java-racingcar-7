package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.UserView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserView userView = new UserView(new RacingCarController());
        userView.start();
    }
}
