package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.message.RunMessage;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class RacingController {

    private final CarService carService;
    private final RacingService racingService;

    public RacingController(CarService carService, RacingService racingService) {
        this.carService = carService;
        this.racingService = racingService;
    }

    public void startRacing() {
        String carNames = InputView.inputCarNames();

        HashMap<String, Integer> cars = carService.splitCarNames(carNames);

        String inputAttemptCount = InputView.inputAttemptCount();

        int attemptCount = racingService.parseAttemptCount(inputAttemptCount);

        System.out.print(RunMessage.RESULT.getMessage());
        for (int i = 0; i < attemptCount; i++) {
            for (String carName : cars.keySet()) {
                boolean isForward = racingService.canMove();
                carService.updateCarLocation(cars, carName, isForward);
            }
            OutView.printRacingResult(cars);
        }

        List<String> winner = racingService.racingWinner(cars);

        OutView.printWinner(winner);
    }
}
