package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputview.InputHandler;
import racingcar.outputview.OutputHandler;

import java.util.Arrays;

public class RacingController {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    public RacingController(){
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        outputHandler.promptCarNameInput();
        String[] carNames = inputHandler.split(Console.readLine());
        outputHandler.promptAttemptCountInput();
        int attemptGameCount = inputHandler.getAttemptGameCount();

    }


}
