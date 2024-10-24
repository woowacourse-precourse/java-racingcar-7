package racingcar.controller;

import racingcar.util.StringProcessor;
import racingcar.validator.Validator;
import racingcar.view.InputView;
public class GameController {

    private final Validator<String[]> carValidator;
    private final Validator<String> trialValidator;
    public GameController(Validator<String[]> carValidator, Validator<String> trialValidator){
        this.carValidator = carValidator;
        this.trialValidator = trialValidator;
    }
    public void run(){

        String userCarInput = InputView.userInputCar();
        String[] carNameArr = StringProcessor.process(userCarInput);
        // validate
        carValidator.validate(carNameArr);

        String userTrialInput = InputView.userInputTrial();
        trialValidator.validate(userTrialInput);

        // parse

    }
}
