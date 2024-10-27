package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.RacingInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInputView racingInputView = new RacingInputView();
        RacingService racingService = new RacingService();

        RacingController racingController = new RacingController(racingInputView, racingService);
        racingController.run();
    }
}
