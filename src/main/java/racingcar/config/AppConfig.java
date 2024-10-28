package racingcar.config;

import racingcar.controller.GameController;
import racingcar.domain.movestrategy.MoveStrategy;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.movestrategy.RandomMoveStrategy;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.io.input.CliInputReader;
import racingcar.io.output.CliOutputWriter;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController gameController() {
        return new GameController(
                gameService(),
                inputView(),
                outputView()
        );
    }

    public GameService gameService() {
        return new GameService(moveStrategy());
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

    public MoveStrategy moveStrategy() {
        return new RandomMoveStrategy(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
