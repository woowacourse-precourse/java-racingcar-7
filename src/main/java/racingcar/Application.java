package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.util.RandomPicker;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomPicker randomPicker = new RandomPicker();
        RacingCarService racingCarService = new RacingCarService(randomPicker);
        RacingCarController racingCarController = new RacingCarController(racingCarService);

        racingCarController.run();

    }
}
