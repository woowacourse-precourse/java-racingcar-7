package racingcar.controller;

import racingcar.exception.BlankException;
import racingcar.exception.DuplicateException;
import racingcar.exception.LengthException;
import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.*;

public class GameController {

    private List<Car> cars;
    private InputView inputView;

    public void startGame() {
        String inputCarsName = inputView.getInput();
        String[] splitCar = inputCarsName.split(",");

        for (String s : splitCar) {
            s = s.trim();
            if (s.isEmpty()) {
                throw new BlankException();
            }
            if (s.length() > 5) {
                throw new BlankException();
            }
            cars.add(new Car(s));
        }

        HashSet<String> set = new HashSet<>(List.of(splitCar));
        if (splitCar.length != set.size()) {
            throw new DuplicateException();
        }



    }
}
