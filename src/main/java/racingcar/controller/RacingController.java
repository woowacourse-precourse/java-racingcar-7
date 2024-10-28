package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();
    OutPutView outPutView = new OutPutView();


    public void startGame() {

        String names = inputView.readName();
        String tryNumber = inputView.readTryNumber();
        inputValidator.validate(names, tryNumber);

        RacingGame racingGame = new RacingGame(addCarName(names), Integer.parseInt(tryNumber));
        List<String> winners = racingGame.race();
        outPutView.printWinners(winners);
    }

    private static ArrayList<Car> addCarName(String names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names.split(",")) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }
}
