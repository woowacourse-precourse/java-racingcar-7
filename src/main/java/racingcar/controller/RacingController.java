package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Judge;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;
    private final Judge judge;

    public RacingController(InputView inputView, OutputView outputView, CarFactory carFactory, Judge judge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
        this.judge = judge;
    }

    public void startGame() {
        List<Car> carList = carFactory.createCar(inputView.inputCarNames());
        Long movingCount = inputView.inputMovingCount();

        outputView.printRacingResultTitle();

        for (int i = 0; i < movingCount; i++) {
            moveCars(carList);
            outputView.printRacingResult(carList);
        }

        outputView.printWinners(judge.getWinners(carList));
    }

    private void moveCars(List<Car> carList) {
        carList.forEach(car -> {
            if (judge.judgeGoOrStop(RandomNumberGenerator.generateRandomNumber())) {
                car.move();
            }
        });
    }
}
