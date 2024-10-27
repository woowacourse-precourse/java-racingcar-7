package racingcar.view.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.winner.MaxPositionWinnerStrategy;
import racingcar.strategy.winner.WinnerStrategy;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceOutputTest {
    @Test
    @DisplayName("경주 진행 사항이 정상적으로 출력되는지 테스트")
    void 경주_진행_사항_출력() {
        // given
        Set<String> carNames = new LinkedHashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
        int attemptCount = 3;

        MovementStrategy alwaysMoveStrategy = () -> true;
        WinnerStrategy maxPositionWinnerStrategy = new MaxPositionWinnerStrategy();

        Race race = new Race(carNames, attemptCount, alwaysMoveStrategy, maxPositionWinnerStrategy);

        // when
        race.start();
        String output = RaceOutput.getProgress(race);

        // then
        String expectedOutput = "pobi : ---\nwoni : ---\njun : ---\n";
        assertEquals(expectedOutput, output);
    }
}
