package racingcar.controller;

import racingcar.model.RaceProcess;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;
import java.util.*;

public class RacingController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RaceProcess raceProcess;

    private static HashMap<String, Integer> carRacingResult;

    public RacingController(InputHandler inputHandler, OutputHandler outputHandler, RaceProcess raceProcess) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.raceProcess = raceProcess;
    }

    public void run() {
        String input_cars = inputHandler.getInputCars();
        String input_nums = inputHandler.getInputNum();

        carRacingResult = racingControl(input_cars, input_nums);

        List<String> winner = raceProcess.findWinner(carRacingResult);

        outputHandler.printWinner(winner);
    }

    public HashMap<String, Integer> racingControl(String input_cars, String input_nums) {
        carRacingResult = raceProcess.initProcess(raceProcess.readyCar(input_cars));
        int number = raceProcess.readyNum(input_nums);

        for (int i = 0; i < number; i++) {
            carRacingResult = raceProcess.process(carRacingResult);
            outputHandler.printProcess(carRacingResult);
        }
        return carRacingResult;
    }
}
