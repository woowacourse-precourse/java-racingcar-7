package racingcar.controller;

import racingcar.message.ExceptionCode;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String inputCarNameList = inputView.inputCarNames();

        String[] carNameList = inputCarNameList.split(",");

        int inputTurns = 0;
        try {
            inputTurns = Integer.parseInt(inputView.inputTurnCount());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TURN.getDescription());
        }
        System.out.println();

        for (final String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionCode.CAR_NAME_LENGTH_5.getDescription());
            }

            Car car = new Car(name);
        }
    }

}
