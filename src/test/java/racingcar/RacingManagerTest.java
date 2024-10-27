package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingManagerTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi, woni, jun"})
    void 자동차_이름이_복수인_경우_쉼표_구분(String rawName) {
        List<String> carNames = Arrays.stream(rawName.split(",")).toList();
        RacingManager manager = new RacingManager(carNames, 1);
        List<Car> cars = manager.getCars();

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 시도횟수는_양의_정수(int stageCount) {
        RacingManager manager = new RacingManager(List.of("pobi", "woni", "jun"), stageCount);

        assertThat(manager.getStageCount()).isEqualTo(stageCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 차수별_실행_결과를_출력(int stageCount) {
        RacingManager manager = new RacingManager(List.of("pobi", "woni", "jun"), stageCount);
        List<StageResult> result = manager.startRace();

        assertThat(result.size()).isEqualTo(stageCount);
    }

    @Test
    void 가장_많이_전진한_자동차가_우승() {
        RacingManager manager = new RacingManager(List.of("pobi", "woni", "jun"), 1);
        manager.getCars().getFirst().attemptMove(4);

        assertThat(manager.winners()).containsExactly("pobi");
    }
}
