package racingcar.controller;

import static racingcar.service.ValidationService.validateGameCount;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;
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
            playingPerGame(gameDataDto.getCars());
        }
    }

    private void playingPerGame (Cars cars) {
        for (int i = 0; i < cars.size(); i ++) {
            RandomNumber randomNumber = createRandomNumber();
            carService.movePerCar(cars, randomNumber, i);
        }
    }

    private RandomNumber createRandomNumber ( ) {
        return new RandomNumber();
    }

}
