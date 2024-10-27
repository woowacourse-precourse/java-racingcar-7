package racingcar.config;

import racingcar.controller.GameController;
import racingcar.io.input.CliInputReader;
import racingcar.io.output.CliOutputWriter;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController gameController() {
        return new GameController(
                new GameService(),
                inputView(),
                outputView()
        );
    }

    public InputView inputView() {
        return new InputView(
                new CliInputReader(),
                new CliOutputWriter()
        );
    }

    public OutputView outputView() {
        return new OutputView(new CliOutputWriter());
    }

}
