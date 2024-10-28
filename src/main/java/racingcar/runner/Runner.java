package racingcar.runner;

import racingcar.application.Racing;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Runner {

    public static void run() {
        List<Car> cars = InputView.getCars();
        int trialCount = InputView.getTrialCount();

        Racing racing = Racing.getInstance(cars);

        System.out.println("실행 결과");
        racing.race(trialCount);

        List<String> winners = racing.determineWinners();
        OutputView.printWinners(winners);
    }
}
