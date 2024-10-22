package racingcar.controller;

import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;
import java.util.*;

public class RacingController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        String input_cars = inputHandler.getInput();
        String input_nums = inputHandler.getInput();
//        List<String> winner = /*여기 몰루?;*/;
//        outputHandler.printWinner(winner);
    }
}
