package racingcar.controller;

import racingcar.model.util.StringProcessor;
import racingcar.model.validator.CarNameValidator;
import racingcar.view.InputView;
public class GameController {

    private final StringProcessor stringProcessor;
    private final CarNameValidator carNameValidator;
    public GameController(StringProcessor stringProcessor, CarNameValidator carNameValidator){
        this.stringProcessor = stringProcessor;
        this.carNameValidator = carNameValidator;
    }
    public void run(){
        String userCarInput = InputView.userInputCar();

        String[] carNameArr = stringProcessor.process(userCarInput);

        // validate
        carNameValidator.validateCarNames(carNameArr);
        
        // parse

        String userTrialInput = InputView.userInputTrial();
    }
}
