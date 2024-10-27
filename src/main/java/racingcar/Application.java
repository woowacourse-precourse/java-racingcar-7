package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.BasicRacingGameService;
import racingcar.service.RacingGameService;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        RacingGameService service = new BasicRacingGameService();

        RacingGameController controller = new RacingGameController(inputView, outputView, service);

        controller.run();
    }
}
