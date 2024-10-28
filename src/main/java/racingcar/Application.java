package racingcar;

import controller.RacingGameController;
import service.RacingGameService;
import util.validator.*;
import view.InputView;
import view.OutputView;
import util.randomnumber.RandomNumberHandler;
import util.randomnumber.RandomNumberHandlerImpl;
import util.splitter.CarNameSplitter;
import util.splitter.CarNameSplitterImpl;

public class Application {
    private final RacingGameController racingGameController;
    public Application(RacingGameController racingGameController) {
        this.racingGameController = racingGameController;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator<String> carNameValidator = new CarNameValidatorImpl();
        Validator<Integer> raceCountValidator = new RaceCountValidatorImpl();
        ParseValidator parseValidator = new ParseIntValidator();

        InputView inputView = new InputView(carNameValidator, raceCountValidator, parseValidator);
        OutputView outputView = new OutputView();

        CarNameSplitter carNameSplitter = new CarNameSplitterImpl();
        RandomNumberHandler randomNumberHandler = new RandomNumberHandlerImpl();

        RacingGameService raceService = new RacingGameService(randomNumberHandler, outputView);
        RacingGameController racingGamecontroller = new RacingGameController(inputView, outputView, carNameSplitter, raceService);
        racingGamecontroller.run();
    }
}