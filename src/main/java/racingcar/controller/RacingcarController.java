package racingcar.controller;

import java.util.List;
import racingcar.entity.Car;
import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class RacingcarController {

    private final RacingcarView racingcarView;
    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarView racingcarView, RacingcarService racingcarService) {
        this.racingcarView = racingcarView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        String rawCarName = racingcarView.carNameInput();
        List<String> parsedCarName = racingcarService.parseCarName(rawCarName);
        racingcarService.validateCarName(parsedCarName);

        String trialCount = racingcarView.trialCountInput();
        racingcarService.validateNumber(trialCount);

        List<Car> cars = racingcarService.createCar(parsedCarName);

        System.out.println("실행결과");
        for (int i = 1; i <= Integer.parseInt(trialCount); i++) {
            List<Car> result = racingcarService.race(cars);
            racingcarView.printResult(result);
        }

        racingcarView.printWinners(cars);
    }
}