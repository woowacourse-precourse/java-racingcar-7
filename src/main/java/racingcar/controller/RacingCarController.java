package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.CarMakerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final CarMakerService carMakerService;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingCarController(InputView inputView,
                               CarMakerService carMakerService,
                               RandomNumberGenerator randomNumberGenerator,
                               OutputView outputView) {
        this.inputView = inputView;
        this.carMakerService = carMakerService;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

    public void startGame() {
        String carNames = inputView.scanCarNames();
        int tryCount = inputView.scanTryCount();
        playGame(carNames, tryCount);
    }

    private void playGame(String carNames, int tryCount) {
        List<Car> cars = carMakerService.makeCars(carNames);

        outputView.printMoveResultMessage();

        for(int i=0; i<tryCount; i++){

            for(Car car : cars){
                int randomNumber = randomNumberGenerator.makeRandomNumber();
                car.move(randomNumber);
            }

            outputView.printMovedCars(cars);
            System.out.println();
        }
    }
}
