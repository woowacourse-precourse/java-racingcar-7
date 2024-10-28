package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingCar;
import racingcar.service.CarNameParser;
import racingcar.service.RacingGamePresenter;
import racingcar.service.RacingGame;
import racingcar.service.RandomMovementStrategy;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

import java.util.List;

import static racingcar.common.constant.OutputConstant.*;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        consoleOutput.print(INPUT_CAR_NAME);
        String carName = consoleInput.inputString();

        consoleOutput.print(INPUT_TRY_COUNT);
        Integer carTryCount = consoleInput.inputNumber();

        CarNameParser carNameParser = new CarNameParser(carName);
        List<String> carNames = carNameParser.parse();

        List<RacingCar> racingCarList = carNames.stream().map(RacingCar::new).toList();

        RandomMovementStrategy randomMovementStrategy = new RandomMovementStrategy();
        RacingGame racingGame = new RacingGame(racingCarList, randomMovementStrategy, carTryCount);
        RacingGamePresenter racingGamePresenter = new RacingGamePresenter();

        RacingGameController racingGameController = new RacingGameController(racingGame, racingGamePresenter);
        String racingResult = racingGameController.playGame();

        consoleOutput.print(racingResult.toString());
    }
}
