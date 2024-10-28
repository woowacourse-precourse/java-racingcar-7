package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Judge;
import racingcar.model.NumberStringConverter;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;
    private final Judge judge;
    private final NumberStringConverter numberStringConverter;

    public RacingController(InputView inputView, OutputView outputView, CarFactory carFactory, Judge judge,
                            NumberStringConverter numberStringConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
        this.judge = judge;
        this.numberStringConverter = numberStringConverter;
    }

    public void startGame() {
        List<Car> carList = carFactory.createCar(inputView.inputCarNames());

        String RawMovingCount = inputView.inputMovingCount();
        Long movingCount = numberStringConverter.convert(RawMovingCount);

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
