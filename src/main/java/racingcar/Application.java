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
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        SeparatorParser separatorParser = new SeparatorParser();
        InputValidator inputValidator = new InputValidator();
        RacingCarService racingCarService = new RacingCarService(separatorParser, inputValidator);
        RacingController racingController = new RacingController(inputView, outputView, racingCarService);

        HashMap<String, String> inputInformation = racingController.input();
        racingController.init(inputInformation);
        String winnerMessage = racingController.racing();
        racingController.output(winnerMessage);
    }
}
