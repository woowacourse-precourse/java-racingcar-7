package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.NumberConverter;
import racingcar.util.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringParser stringParser = new StringParser();
        NumberConverter numberConverter = new NumberConverter();

        RacingGameController racingGameController = new RacingGameController(inputView, outputView, stringParser, numberConverter);
        racingGameController.run();
    }
}
