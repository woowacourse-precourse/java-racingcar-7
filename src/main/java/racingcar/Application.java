package racingcar;


import controller.RacingGameController;
import service.RacingGameService;
import util.randomnumber.RandomNumberHandler;
import util.splitter.CarNameSplitter;
import view.InputView;
import view.OutputView;
import util.validator.CarNameValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarNameValidator carNameValidator = new CarNameValidator();
        CarNameSplitter carNameSplitter = new CarNameSplitter(carNameValidator);
        RandomNumberHandler randomNumberHandler = new RandomNumberHandler();

        RacingGameService raceService = new RacingGameService(randomNumberHandler, outputView);
        RacingGameController controller = new RacingGameController(inputView, outputView, carNameSplitter, raceService);
        controller.startGame();
    }
}