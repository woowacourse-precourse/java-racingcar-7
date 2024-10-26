package racingcar.controller;

import java.util.List;

public class RacingController {
    private final InputHandler inputHandler;
    public RacingController(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }
    public void run() {
        List<String> racingCars = inputHandler.getCarInput();
        Integer iteration = inputHandler.getIterationInput();
    }
}
