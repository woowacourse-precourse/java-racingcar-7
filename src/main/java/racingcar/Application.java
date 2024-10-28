package racingcar;

import racingcar.controller.RacingGameController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();

        // 자동차 이름 입력 + 검증
        List<String> carNames = controller.parseCarNames();

        // 시도 횟수 입력 + 검증
        int attemptCount = controller.getAttemptCount();
    }
}
