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
        List<String> carNames = carNameRun();
        int trialCount = trialCountRun();
        List<Car> cars = racingcarService.createCar(carNames);
        printResultRun(trialCount, cars);
        racingcarView.printWinners(cars);
    }
    
    public List<String> carNameRun() {
        String rawCarName = racingcarView.carNameInput();
        List<String> parsedCarName = racingcarService.parseCarName(rawCarName);
        racingcarService.validateCarName(parsedCarName);
        return parsedCarName;
    }

    public int trialCountRun() {
        String trialCount = racingcarView.trialCountInput();
        racingcarService.validateNumber(trialCount);
        return Integer.parseInt(trialCount);
    }

    public void printResultRun(int trialCount, List<Car> cars) {
        System.out.println("실행결과");
        for (int i = 1; i <= trialCount; i++) {
            List<Car> result = racingcarService.race(cars);
            racingcarView.printResult(result);
        }
    }
}