package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.converter.GameOverDTOConverter;
import racingcar.service.CarService;
import racingcar.service.InputProcessService;
import racingcar.view.GameOverView;
import racingcar.view.GameStartView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController racingGameController = new RacingGameController(
                new GameStartView(),
                new GameOverView(),
                new InputProcessService(),
                new CarService(),
                new GameOverDTOConverter()
        );

        racingGameController.startGame();
    }
}
