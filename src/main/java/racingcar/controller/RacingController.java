package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class RacingController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();


    public void startGame() {

        String names = inputView.readName();
        String tryNumber = inputView.readTryNumber();
        inputValidator.validate(names, tryNumber);

        RacingGame racingGame = new RacingGame(addCarName(names), Integer.parseInt(tryNumber));
        racingGame.race();
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
