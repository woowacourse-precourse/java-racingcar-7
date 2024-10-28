package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();

        // 자동차 이름 입력 + 검증
        List<String> carNames = controller.parseCarNames();

        // 시도 횟수 입력 + 검증
        int attemptCount = controller.getAttemptCount();

        //레이스 시작
        for (int i = 0; i < attemptCount; i++) {
            controller.startRace();
            OutputView.printRaceStatus(controller.getCars());
            System.out.println();
        }

        // 최종 우승자 출력
        List<Car> winners = controller.getWinners();
        OutputView.printWinners(winners);
    }
}
