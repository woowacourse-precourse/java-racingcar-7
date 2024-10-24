package racingcar.controller;

import racingcar.model.util.StringProcessor;
import racingcar.model.validator.Validator;
import racingcar.view.InputView;
public class GameController {

    private final StringProcessor stringProcessor;
    private final Validator<String[]> carValidator;
    private final Validator<String> trialValidator;
    public GameController(StringProcessor stringProcessor, Validator<String[]> carValidator, Validator<String> trialValidator){
        this.stringProcessor = stringProcessor;
        this.carValidator = carValidator;
        this.trialValidator = trialValidator;
    }
    public void run(){

        String userCarInput = InputView.userInputCar();
        String[] carNameArr = stringProcessor.process(userCarInput);

        // validate
        carValidator.validate(carNameArr);

        String userTrialInput = InputView.userInputTrial();
        trialValidator.validate(userTrialInput);

        // parse

    }
}
