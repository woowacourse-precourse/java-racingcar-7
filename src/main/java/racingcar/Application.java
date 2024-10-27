package racingcar;

import java.util.HashMap;
import racingcar.controller.RacingController;
import racingcar.service.RacingCarService;
import racingcar.util.SeparatorParser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarService racingCarService = new RacingCarService(new SeparatorParser(), new InputValidator());
        RacingController racingController = new RacingController(new InputView(), new OutputView(), racingCarService);

        HashMap<String, String> inputInformation = racingController.input();
        racingController.init(inputInformation);
        String winnerMessage = racingController.racing();
        racingController.output(winnerMessage);
    }
}
