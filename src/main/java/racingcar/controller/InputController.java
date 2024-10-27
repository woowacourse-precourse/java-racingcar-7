package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.message.ExceptionCode;
import racingcar.view.InputCarNamesView;
import racingcar.view.InputTurnCountView;

public class InputController {

    private final InputCarNamesView inputCarNamesView;
    private final InputTurnCountView inputTurnCountView;

    public InputController(InputCarNamesView inputCarNamesView, InputTurnCountView inputTurnCountView) {
        this.inputCarNamesView = inputCarNamesView;
        this.inputTurnCountView = inputTurnCountView;
    }

    public InputDTO getInput() {
        String[] carList = getCarNameList();
        int inputTurnCount = getTurnCount();

        System.out.println();

        return new InputDTO(carList, inputTurnCount);
    }

    private String[] getCarNameList() {
        String inputCarNameList = inputCarNamesView.getCarNames();

        return inputCarNameList.split(",");
    }

    private int getTurnCount() {
        try {
            return Integer.parseInt(inputTurnCountView.getTurnCount());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TURN.getDescription());
        }
    }

}
