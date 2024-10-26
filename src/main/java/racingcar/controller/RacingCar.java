package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.SplitCar;
import racingcar.model.Turn;
import racingcar.view.InputCarName;
import racingcar.view.InputTurn;

public class RacingCar {
    final int MAX_NAME_LENGTH = 5;

    private final List<Car> carList;
    private int playTurn;

    public RacingCar() {
        this.carList = new ArrayList<>();

        InputCarName inputCarName = new InputCarName();
        SplitCar splitCar = new SplitCar(inputCarName.getCarName());
        InputTurn inputTurn = new InputTurn();
        Turn turn = new Turn(inputTurn.getTurn());

        List<String> carNames = splitCar.getSplitCarNames();
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(carName);
            this.carList.add(car);
        }

        this.playTurn = turn.getTurn();
    }
}