package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.AppConstants;
import racingcar.domain.MoveCount;
import racingcar.service.CarService;
import racingcar.utility.CarNameParser;
import racingcar.view.InputView;

public class InputController {

    private final CarService carService;

    private final InputView inputView;

    public InputController(CarService carService, InputView inputView) {
        this.carService = carService;
        this.inputView = inputView;
    }

    public void postNames() {
        List<String> carNames = getCarNamesFromUser();
        registerCar(carNames);
    }


    private void registerCar(List<String> carNames) {
        carNames.forEach(carService::register);
    }

    private List<String> getCarNamesFromUser() {
        String carNamesAsString = getCarNamesAsString();
        return CarNameParser.parseCarNames(carNamesAsString);
    }

    private String getCarNamesAsString() {
        inputView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public MoveCount getMoveCount() {
        inputView.showRequestMessage(AppConstants.REQUEST_MOVE_COUNT_MESSAGE);
        int moveCount = 0;
        try {
            moveCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("아무 숫자도 입력하지 않음");
        }

        if (moveCount <= 0) {
            throw new IllegalArgumentException();
        }

        return new MoveCount(moveCount);
    }
}
