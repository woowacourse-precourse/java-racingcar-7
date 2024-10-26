package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovementStrategy;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    @Test
    @DisplayName("주어진 횟수만큼 경주가 진행되는지 테스트")
    void 주어진_횟수만큼_경주_진행() {
        // given
        Set<String> carNames = new HashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;

        // when
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy);
        race.start();

        // then
        assertEquals(attemptCount, race.getAttemptCount());
    }

    @Test
    @DisplayName("자동차가 무작위로 전진하거나 멈추는지 테스트")
    void 자동차가_무작위로_전진하거나_멈춤() {
        // given
        Set<String> carNames = new HashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy randomMoveStrategy = new racingcar.strategy.RandomMovementStrategy();

        // when
        Race race = new Race(carNames, attemptCount, randomMoveStrategy);
        race.start();

        // then
        for (String carName : carNames) {
            int position = race.getCarPosition(carName);
            assertTrue(position >= 0 && position <= attemptCount);
        }
    }
}