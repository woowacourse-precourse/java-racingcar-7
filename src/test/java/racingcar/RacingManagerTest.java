package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingManagerTest {

    private static final RacingManager racingManager = new RacingManager();

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi, woni, jun"})
    void 자동차_이름이_복수인_경우_쉼표_구분(String rawName) {
        List<Car> cars = racingManager.assignCars(rawName);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 시도횟수는_양의_정수() {
        racingManager.assignTrials(1);

        assertThat(racingManager.getTrials()).isEqualTo(1);
    }
}
