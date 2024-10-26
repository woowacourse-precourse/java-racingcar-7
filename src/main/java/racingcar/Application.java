package racingcar;

import racingcar.domain.Race;
import racingcar.strategy.move.RandomMovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.view.input.InputHandler;
import racingcar.view.output.RaceResultOutput;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        // 1. 자동차 이름 입력받기
        Set<String> carNames = inputHandler.inputCarNames();

        // 2. 시도 횟수 입력받기
        int attemptCount = inputHandler.inputAttemptCount();

        // 3. 전진 전략 및 우승자 결정 전략 설정
        RandomMovementStrategy movementStrategy = new RandomMovementStrategy();
        MaxPositionWinnerStrategy winnerStrategy = new MaxPositionWinnerStrategy();

        // 4. 경주 시작 및 경주 진행 상황 출력
        Race race = new Race(carNames, attemptCount, movementStrategy, winnerStrategy);
        race.start();

        // 5. 최종 우승자 출력
        System.out.println(RaceResultOutput.printWinners(race.getWinners()));
    }
}
