package racingcar.controller;

import static racingcar.service.ValidationService.validateGameCount;

import racingcar.domain.Cars;
import racingcar.dto.GameDataDto;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class Racing {
    private final InputView inputView;
    private final CarService carService;

    public Racing() {
        this.inputView = new InputView();
        this.carService = new CarService();
    }


    public void playGame() {
        GameDataDto gameDataDto = ready();
    }

    public GameDataDto ready () {
        String rawCarNames = inputView.getCarNames();
        Cars cars = carService.createCars(rawCarNames);

        String rawGameCnt = inputView.getGameCount();
        validateGameCount(rawGameCnt);
        Integer gameCnt = Integer.parseInt(rawGameCnt);

        return new GameDataDto(cars, gameCnt);
    }

}
