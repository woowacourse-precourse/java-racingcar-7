package racingcar;


import racingcar.controller.RacingController;
import racingcar.model.RacingcarModel;
import racingcar.view.RacingView;


public class Application {

    public static void main(String[] args) {
        RacingcarModel model = new RacingcarModel();
        RacingView view = new RacingView();
        RacingController controller = new RacingController(model, view);

        controller.run();  // 게임 실행

    }
}
