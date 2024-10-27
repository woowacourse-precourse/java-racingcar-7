package racingcar.view.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceResultOutputTest {
    @Test
    @DisplayName("단독 우승자를 출력하는 테스트")
    void 단독_우승자_출력() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, new MaxPositionWinnerStrategy());

        // when
        race.start();
        String output = RaceResultOutput.printWinners(race.getWinners());

        // then
        assertEquals("최종 우승자 : pobi", output);
    }

    @Test
    @DisplayName("공동 우승자를 출력하는 테스트")
    void 공동_우승자_출력() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 5;

        MovementStrategy alwaysMoveStrategy = () -> true;
        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, new MaxPositionWinnerStrategy());

        // when
        race.start();
        String output = RaceResultOutput.printWinners(race.getWinners());

        // then
        assertEquals("최종 우승자 : pobi, woni, jun", output);
    }
}
