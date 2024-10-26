package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.InputModel;
import racingcar.validation.Validate;
import racingcar.view.InputView;

public class InputController {
    private String userInput;
    private final InputModel inputModel = new InputModel();
    private final InputView inputView = new InputView();
    public InputController(){
    }

    public void validateInputFormat(){
        inputView.printCarNameInputPrompt();
        this.userInput = inputModel.getName();
        Validate.validateTrailingComma(userInput);
    }

    public void validateNameLength(){
        for(String i : inputModel.splitCarNames()){
            Validate.validateNameLengthWithinLimit(i);
        }
    }
    public void validateNonEmptyNames(){
        for(String i : inputModel.splitCarNames()){
            Validate.validateNameNotEmpty(i);
        }
    }
    public void addCarsFromInput(Cars cars){
        for(String i : inputModel.splitCarNames()){
            cars.addCarByName(i);
        }
    }
}
