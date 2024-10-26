package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.move.RandomMovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.strategy.winner.WinnerStrategy;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    @Test
    @DisplayName("주어진 횟수만큼 경주가 진행되는지 테스트")
    void 주어진_횟수만큼_경주_진행() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;
        WinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();

        // when
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, maxPositionWinnerStrategy);
        race.start();

        // then
        assertEquals(attemptCount, race.getAttemptCount());
    }

    @Test
    @DisplayName("자동차가 무작위로 전진하거나 멈추는지 테스트")
    void 자동차가_무작위로_전진하거나_멈춤() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy randomMoveStrategy = new RandomMovementStrategy();
        WinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();

        // when
        Race race = new Race(carNames, attemptCount, randomMoveStrategy, maxPositionWinnerStrategy);
        race.start();

        // then
        for (String carName : carNames) {
            int position = race.getCarPosition(carName);
            assertTrue(position >= 0 && position <= attemptCount);
        }
    }

    @Test
    @DisplayName("최종 우승자가 한 명인 경우 테스트")
    void 단독_우승자_결정() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;
        WinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();

        // when
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, maxPositionWinnerStrategy);
        race.start();

        // then
        Car winner = race.getWinners().get(0);
        assertEquals("pobi", winner.getName());
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우 테스트")
    void 공동_우승자_결정() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;
        WinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();

        // when
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, maxPositionWinnerStrategy);
        race.start();

        // then
        Set<Car> winners = new LinkedHashSet<>(race.getWinners());

        assertEquals(3, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("pobi")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("woni")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("jun")));
    }
}