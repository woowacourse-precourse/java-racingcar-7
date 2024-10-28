package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarController;
import racingcar.controller.RaceController;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.view.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        CarService carService = new CarService();
        RaceService raceService = new RaceService();
        CarController carController = new CarController(carService);
        RaceController raceController = new RaceController(raceService);

        try{
            List<Car> raceCars = carController.generateCars(inputView.getCarNames());
            int attemptNum = raceController.findAttemptNum(inputView.getAttemptNum());
            raceController.startRace(raceCars,attemptNum);
        }
        finally {
            Console.close();
        }

    }
}

