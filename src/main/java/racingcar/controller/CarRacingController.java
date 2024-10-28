package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    private final CarService carService;
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingController(CarService carService, GameService gameService, InputView inputView,
                               OutputView outputView) {
        this.carService = carService;
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        String carNames = inputView.getCarsInput();
        int roundCount = inputView.getRoundInput();

        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }

        List<Car> cars = carService.createCars(carNames.split(","));

        outputView.displayGameStart();

        for (int i = 0; i < roundCount; i++) {
            carService.moveCars(cars);
            outputView.displayRound(cars);
        }

//        IntStream.range(0,roundCount)
//                .forEach(i -> {
//                    carService.moveCars(cars);
//                    outputView.displayRound(cars);
//                });

        List<Car> winners = gameService.selectWinners(cars);
        outputView.displayWinner(winners);
    }
}
