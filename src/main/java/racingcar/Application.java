package racingcar;

import java.util.List;
import racingcar.config.AppConfig;
import racingcar.controller.CarController;
import racingcar.controller.Controller;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Controller controller = appConfig.createController();
        CarController carController = appConfig.createCarController();
        RaceController raceController = appConfig.createRaceController();
        InputController inputController = appConfig.createInputController();
        OutputController outputController = appConfig.createOutputController();

        String inputCarNames = inputController.inputCarNames();
        int inputAttemptCount = inputController.inputAttemptCount();

        List<String> carNames = carController.getCarNames(inputCarNames);
        List<Car> carList = carController.registerCar(carNames);

        Race race = raceController.registerRace(carList, inputAttemptCount);
        controller.playGame(race);
        
        List<Car> winnerCarList = raceController.getWinnerCarList(race);
        outputController.printWinners(winnerCarList);
    }
}
