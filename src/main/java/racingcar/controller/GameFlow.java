package racingcar.controller;

public class GameFlow {

    public GameFlow() {}

    public void start() {
        createCars();
        inputNumberOfSteps();
        runRace();
        displayWinners();
    }

}
