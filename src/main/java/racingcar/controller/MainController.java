package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.AppConstants;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.utility.CarNameParser;
import racingcar.view.InputView;

public class MainController {

    private final CarService carService;

    private final GameService gameService;

    private final InputView inputView;

    public MainController(CarService carService, GameService gameService, InputView inputView) {
        this.carService = carService;
        this.gameService = gameService;
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = getCarNamesFromUser();
        registerCar(carNames);

        int moveCount = getMoveCount();
        gameService.executeRace(moveCount);
    }

    private void registerCar(List<String> carNames) {
        carNames.forEach(carService::register);
    }

    private List<String> getCarNamesFromUser() {
        String carNamesAsString = getCarNamesAsString();
        CarNameParser.parseCarNames(carNamesAsString);
    }

    private String getCarNamesAsString() {
        inputView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    private int getMoveCount() {
        inputView.showRequestMessage(AppConstants.REQUEST_MOVE_COUNT_MESSAGE);
        int moveCount = 0;
        try {
            moveCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("아무 숫자도 입력하지 않음");
        }

        if (moveCount < 0) {
            throw new IllegalArgumentException();
        }

        return moveCount;
    }
}
