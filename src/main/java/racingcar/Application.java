package racingcar;

import controller.RacingGameController;
import movement.CarMovementHandler;
import movement.MovementHandler;
import service.RacingGameService;
import splitter.CarNameSplitter;
import splitter.CarNameSplitterImpl;
import validator.CarNameValidator;
import validator.ParseIntValidator;
import validator.ParseValidator;
import validator.RaceCountValidator;
import validator.Validator;
import view.InputView;
import view.OutputView;

public class Application {
    private final RacingGameController racingGameController;

    public Application(RacingGameController racingGameController) {
        this.racingGameController = racingGameController;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator<String> carNameValidator = new CarNameValidator();
        Validator<Integer> raceCountValidator = new RaceCountValidator();
        ParseValidator parseValidator = new ParseIntValidator();

        InputView inputView = new InputView(carNameValidator, raceCountValidator, parseValidator);
        OutputView outputView = new OutputView();

        CarNameSplitter carNameSplitter = new CarNameSplitterImpl();
        MovementHandler randomNumberHandler = new CarMovementHandler();

        RacingGameService raceService = new RacingGameService(randomNumberHandler, outputView);
        RacingGameController racingGamecontroller = new RacingGameController(inputView, outputView, carNameSplitter,
                raceService);
        racingGamecontroller.run();
    }
}