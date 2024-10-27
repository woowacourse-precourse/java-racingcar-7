package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.UserInputHandler;
import racingcar.validation.NameValidator;
import racingcar.view.InputView;

public class InputController {
    private String userInput;
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final InputView inputView = new InputView();
    public InputController(){
    }

    public void validateInputFormat(){
        inputView.printCarNameInputPrompt();
        this.userInput = userInputHandler.inputCarNames();
        NameValidator.validateTrailingComma(userInput);
    }

    public void validateNameLength(){
        for(String i : userInputHandler.splitCarNames()){
            NameValidator.validateNameLengthWithinLimit(i);
        }
    }
    public void validateNonEmptyNames(){
        for(String i : userInputHandler.splitCarNames()){
            NameValidator.validateNameNotEmpty(i);
        }
    }
    public void addCarsFromInput(Cars cars){
        for(String i : userInputHandler.splitCarNames()){
            cars.addCarByName(i);
        }
    }
}
