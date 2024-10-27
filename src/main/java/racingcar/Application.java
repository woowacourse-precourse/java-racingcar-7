package racingcar;

import controller.RacingGameController;
import service.RacingGameService;
import util.randomnumber.RandomNumberHandler;
import util.splitter.CarNameSplitter;
import view.InputView;
import view.OutputView;
import util.validator.CarNameValidator;
import util.validator.RaceCountValidator;
import util.validator.CarNameValidatorImpl;
import util.validator.RaceCountValidatorImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameValidator carNameValidator = new CarNameValidatorImpl();
        RaceCountValidator raceCountValidator = new RaceCountValidatorImpl();
        InputView inputView = new InputView(carNameValidator, raceCountValidator);
        OutputView outputView = new OutputView();
        CarNameSplitter carNameSplitter = new CarNameSplitter();
        RandomNumberHandler randomNumberHandler = new RandomNumberHandler();
        RacingGameService raceService = new RacingGameService(randomNumberHandler, outputView);
        RacingGameController controller = new RacingGameController(inputView, outputView, carNameSplitter, raceService);
        controller.startGame();
    }
}