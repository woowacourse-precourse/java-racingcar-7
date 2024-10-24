package racingcar.controller;

import racingcar.model.util.StringProcessor;
import racingcar.view.InputView;
public class GameController {

    private final StringProcessor stringProcessor;

    public GameController(StringProcessor stringProcessor){
        this.stringProcessor = stringProcessor;
    }
    public void run(){
        String userCarInput = InputView.userInputCar();

        String[] carNameArr = stringProcessor.process(userCarInput);

        // validate

        // parse

        String userTrialInput = InputView.userInputTrial();
    }
}
