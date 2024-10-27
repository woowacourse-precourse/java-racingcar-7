package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.message.ExceptionCode;
import racingcar.model.Car;
import racingcar.view.InputCarNamesView;
import racingcar.view.InputTurnCountView;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    private final InputCarNamesView inputCarNamesView;
    private final InputTurnCountView inputTurnCountView;

    public InputController(InputCarNamesView inputCarNamesView, InputTurnCountView inputTurnCountView) {
        this.inputCarNamesView = inputCarNamesView;
        this.inputTurnCountView = inputTurnCountView;
    }

    public InputDTO getInput() {
        List<Car> carList = convertToCarList(inputCarNamesView.getCarNames());
        int inputTurnCount = turnCountToInt(inputTurnCountView.getTurnCount());

        System.out.println();

        return new InputDTO(carList, inputTurnCount);
    }

    private List<Car> convertToCarList(final String inputCarNames) {
        String[] inputCarNameList = inputCarNames.split(",");
        return carNameListToCarList(inputCarNameList);
    }

    private List<Car> carNameListToCarList(final String[] inputCarNameList) {
        List<Car> carList = new ArrayList<>();

        for (final String name : inputCarNameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        return carList;
    }

    private int turnCountToInt(final String inputTurnCount) {
        int turnCount = 0;
        try {
            turnCount = Integer.parseInt(inputTurnCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TURN.getDescription());
        }
        return validateTurnCount(turnCount);
    }

    private int validateTurnCount(final int turnCount) {
        if (turnCount <= 0) {
            throw new IllegalArgumentException(ExceptionCode.TURN_MORE_THAN_0.getDescription());
        }
        return turnCount;
    }

}
