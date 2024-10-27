package racingcar.controller;

import static racingcar.service.ValidationService.validateGameCount;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;
import racingcar.domain.Winners;
import racingcar.dto.GameDataDto;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
    }


    public void playGame() {
        GameDataDto gameDataDto = ready();

        racing(gameDataDto);

        result(gameDataDto);
    }

    public GameDataDto ready () {
        String rawCarNames = inputView.getCarNames();
        Cars cars = carService.createCars(rawCarNames);

        String rawGameCnt = inputView.getGameCount();
        validateGameCount(rawGameCnt);
        Integer gameCnt = Integer.parseInt(rawGameCnt);

        return new GameDataDto(cars, gameCnt);
    }

    public void result(GameDataDto gameDataDto) {
        Winners winners = carService.getWinners(gameDataDto.getCars());

        String winnerNames = winners.getNames();
        outputView.showWinners(winnerNames);
    }

    private void racing (GameDataDto gameDataDto) {
        outputView.startRacing();

        for (int i = 0; i < gameDataDto.getGameCount(); i ++) {
            playingPerGame(gameDataDto.getCars());
            outputView.perRacing();
        }

    }

    private void playingPerGame (Cars cars) {
        for (int i = 0; i < cars.size(); i ++) {
            RandomNumber randomNumber = createRandomNumber();
            carService.movePerCar(cars, randomNumber, i);
            outputView.getRoundResult(cars, i);
        }
    }

    private RandomNumber createRandomNumber ( ) {
        return new RandomNumber();
    }

}
