package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.CarService;
import racingcar.util.factory.CarFactory;
import racingcar.util.parser.PlayerNameParser;
import racingcar.util.race.RaceExecutor;
import racingcar.util.race.WinnerSelector;
import racingcar.util.validator.PlayerNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PlayerNameParser playerNameParser = new PlayerNameParser();
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        WinnerSelector winnerSelector = new WinnerSelector();
        RaceExecutor raceExecutor = new RaceExecutor();
        CarFactory carFactory = new CarFactory();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarService carService = new CarService(playerNameValidator, winnerSelector, playerNameParser, raceExecutor, carFactory);

        RacingController racingController = new RacingController(inputView, outputView, carService);
        racingController.run();
    }
}
