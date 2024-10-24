package racingcar.controller;

import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;
import racingcar.model.service.CarRacingGame;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.UserDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static racingcar.common.constant.BusinessConst.*;

public class GameController {

    private final CarRacingGame game;
    private final GameResult model;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(CarRacingGame game, GameResult model, InputView inputView, OutputView outputView) {
        this.game = game;
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        UserDto.Input userInput = inputView.getInput();

        CarList carList = convertUserInputToCarList(userInput.getCarName());

        game.play(carList, model, userInput.getCount());
        game.determineWinner(carList, model);

        outputView.noticeResult();
        outputView.printResult(model);
    }

    public CarList convertUserInputToCarList(final String cars) {
        List<Car> carList = Arrays.stream(cars.split(DEFAULT_DELIMITER))
                .map(Car::of)
                .toList();
        return CarList.of(carList);
    }
}
