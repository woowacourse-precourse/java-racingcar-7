package racingcar;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import racingcar.controller.GameController;
import racingcar.extractor.CarNameExtractor;
import racingcar.factory.CarFactory;
import racingcar.model.CarManager;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RaceRoundsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        InputView inputView = new InputView();
        RaceRoundsValidator raceRoundsValidator = new RaceRoundsValidator();
        CarManager carManager = new CarManager(new CarNameValidator(), new CarNameExtractor(), new CarFactory());
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(inputView, raceRoundsValidator, carManager, outputView);
        gameController.startGame();
    }
}
