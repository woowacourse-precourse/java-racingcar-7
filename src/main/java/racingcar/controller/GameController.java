package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class GameController {
    private List<Car> racingCarList;
    private int attemptNumber;
    private final Input input;
    private final Output output;

    public GameController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        setUpInput();
        Race race = new Race(racingCarList, attemptNumber, output);
        race.start();
    }

    private void setUpInput() {
        this.racingCarList = input.getCarName();
        this.attemptNumber = input.getAttemptNumber();
    }
}


