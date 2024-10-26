package racingcar.runner;

import racingcar.application.Racing;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Runner {

    public static void run() {
        // 1. 사용자 입력을 통해 자동차 목록과 시도 횟수를 가져온다.
        List<Car> cars = InputView.getCars();
        int trialCount = InputView.getTrialCount();

        // 2. Racing 객체를 생성하여 경주를 시작한다.
        Racing racing = new Racing(cars);

        // 3. 지정된 횟수만큼 경주를 진행한다.
        System.out.println("실행 결과");
        racing.race(trialCount);

        // 4. 경주가 끝난 후 우승자를 결정한다.
        racing.determineWinners();

        // 5. 우승자 목록을 가져와 출력한다.
        List<String> winners = racing.getWinners();
        OutputView.printWinners(winners);
    }
}
