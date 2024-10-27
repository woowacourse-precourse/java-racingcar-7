package racingcar.controller;

import racingcar.dto.UserInputDto;
import racingcar.util.UserInputValidator;
import racingcar.view.InputView;

public class CarRaceManager {

    private InputView inputView = new InputView();
    private UserInputValidator userInputValidator = new UserInputValidator();
    public void start(){
        String[] userInitialInputs = inputView.getUserInitialInputs();
        UserInputDto userInputDto = userInputValidator.validate(userInitialInputs);

    }
}
