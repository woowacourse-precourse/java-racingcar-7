package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.CarMakerService;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final CarMakerService carMakerService;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarController(InputView inputView,
                               CarMakerService carMakerService,
                               RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.carMakerService = carMakerService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startGame() {
        String carNames = inputView.scanCarNames();
        int tryCount = inputView.scanTryCount();
        playGame(carNames, tryCount);
    }

    public void playGame(String carNames, int tryCount) {
        List<Car> cars = carMakerService.makeCars(carNames);

        for(int i=0; i<tryCount; i++){
            int randomNumber = randomNumberGenerator.makeRandomNumber();

            for(Car car : cars){
                car.move(randomNumber);
            }
        }
    }
}
