package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.domain.Car;
import racingcar.service.RaceGameService;
import racingcar.service.RaceGameServiceImpl;
import racingcar.util.parser.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final StringParser stringParser = new StringParser();
        final RaceGameService raceGameServiceImpl = new RaceGameServiceImpl();
        final RaceGameController raceGameController = new RaceGameController(inputView, outputView, raceGameServiceImpl);

        raceGameController.run();
    }
}
