package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarRacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * RacingController
 * - 자동차 경주 게임의 전체적인 로직을 제어
 */
public class RacingController {
    private final CarRacingService carRacingService = new CarRacingService();

    public void startGame() {
        List<String> carNames = InputView.getCarNames();
        int trialCount = InputView.getTrialCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        System.out.println("\n실행 결과");
        for (int i = 0; i < trialCount; i++) {
            carRacingService.runRound(cars);
            OutputView.printRoundResult(cars);
        }

        List<Car> winners = carRacingService.findWinners(cars);
        OutputView.printWinners(winners);
    }
}
