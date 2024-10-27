package racingcar;


import controller.RacingGameController;
import service.RacingGameService;
import util.randomnumber.RandomNumberHandler;
import util.splitter.CarNameSplitter;
import util.validator.RaceCountValidator;
import view.InputView;
import view.OutputView;
import util.validator.CarNameValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameValidator carNameValidator = new CarNameValidator();
        RaceCountValidator raceCountValidator = new RaceCountValidator();
        InputView inputView = new InputView(carNameValidator, raceCountValidator);
        OutputView outputView = new OutputView();
        CarNameSplitter carNameSplitter = new CarNameSplitter();
        RandomNumberHandler randomNumberHandler = new RandomNumberHandler();
        RacingGameService raceService = new RacingGameService(randomNumberHandler, outputView);
        RacingGameController controller = new RacingGameController(inputView, outputView, carNameSplitter, raceService);
        controller.startGame();
    }
}