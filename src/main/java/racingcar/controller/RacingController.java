package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class RacingController {
    private final InputHandler inputHandler;
    public RacingController(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }
    public void run() {
        List<String> racingCarsName = inputHandler.getCarInput();
        Integer iteration = inputHandler.getIterationInput();

        List<RacingCar> racingCarList = racingCarsName.stream()
                .map(RacingCar::new).toList();
    }
}
