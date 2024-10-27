package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        List<String> carNames = InputView.getCarNames();
        int trialCount = InputView.getTrialCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        CarRacing carRacing = new CarRacing(cars);

        // 게임 라운드별 결과 출력
        System.out.println("\n실행 결과");
        for (int i = 0; i < trialCount; i++) {
            carRacing.runRound();
            OutputView.printRoundResult(carRacing.getCars());
        }

        List<Car> winners = carRacing.findWinners();
        OutputView.printWinners(winners);
    }
}
