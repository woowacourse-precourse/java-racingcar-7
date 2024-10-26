package racingcar;

import java.util.List;
import racingcar.controller.CarController;
import racingcar.controller.Controller;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CarService carService = new CarService();
        RaceService raceService = new RaceService();

        InputController inputController = new InputController(inputView);
        OutputController outputController = new OutputController(outputView);
        CarController carController = new CarController(carService);
        RaceController raceController = new RaceController(raceService);
        Controller controller = new Controller(raceService, outputView);

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
