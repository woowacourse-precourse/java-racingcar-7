package racingcar.controller;

import racingcar.domain.Input;
import racingcar.service.input.InputService;
import racingcar.service.input.Validation;
import racingcar.view.UserInput;
import racingcar.view.constant.Request;

public class InputController {

    private static InputController instance;
    private static final InputService inputService = new InputService();

    private InputController() {}

    public static void getInputs()  {
        Input carNamesInput = rawInput(Request.CAR_NAMES.toString());
        inputService.saveInput(carNamesInput, Validation::carNames);
        Input LapCountInput = rawInput(Request.ATTEMPT_NUMBER.toString());
        inputService.saveInput(LapCountInput, Validation::lapCount);
    }

    private static Input rawInput(String requestMessage) {
         return inputService.receive(requestMessage
                 , UserInput.request(requestMessage));
    }

    public static InputController getInstance() {
        if (instance == null) {
            return new InputController();
        }
        return instance;
    }
}
