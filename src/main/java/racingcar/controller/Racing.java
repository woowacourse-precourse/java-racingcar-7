package racingcar.controller;

import static racingcar.service.ValidationService.validateGameCount;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumbers;
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

        racing(gameDataDto);
    }

    public GameDataDto ready () {
        String rawCarNames = inputView.getCarNames();
        Cars cars = carService.createCars(rawCarNames);

        String rawGameCnt = inputView.getGameCount();
        validateGameCount(rawGameCnt);
        Integer gameCnt = Integer.parseInt(rawGameCnt);

        return new GameDataDto(cars, gameCnt);
    }

    private void racing (GameDataDto gameDataDto) {
        for (int i = 0; i < gameDataDto.getGameCount(); i ++) {
            RandomNumbers randomNumbers = createRandomNumbers(gameDataDto);
            carService.playingPerGame(gameDataDto.getCars(), randomNumbers);
        }
    }

    private RandomNumbers createRandomNumbers (GameDataDto gameDataDto) {
        return new RandomNumbers(gameDataDto.getCars().size());
    }

}
