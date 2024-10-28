package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.PresetService;
import racingcar.service.ProcessService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PresetService presetService = new PresetService();
        ProcessService processService = new ProcessService();

        RacingcarController racingcarController = new RacingcarController(
                inputView,
                outputView,
                presetService,
                processService
        );
        racingcarController.play();
    }
}
