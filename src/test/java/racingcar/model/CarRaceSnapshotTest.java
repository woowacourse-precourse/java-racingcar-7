package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.FixedMovementStrategy;

class CarRaceSnapshotTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", "woni", "jun"};
        FixedMovementStrategy fixedMovementStrategy = new FixedMovementStrategy(4);
        cars = new Cars(carNames, fixedMovementStrategy);

    }

    @Test
    @DisplayName("CarRaceSnapshot을 생성할 수 있다.")
    void canCreateCarRaceSnapshot() {
        // given
        CarRaceSnapshot carRaceSnapshot = new CarRaceSnapshot(cars);

        // when
        List<String> expectedCarNames = List.of("pobi", "woni", "jun");

        // then
        assertThat(carRaceSnapshot.getCarNames()).isEqualTo(expectedCarNames);
    }

    @Test
    @DisplayName("가장 많이 이동한 차 목록을 구할 수 있다.")
    void canGetMaxDistance() {
        // given
        CarRaceSnapshot carRaceSnapshot = new CarRaceSnapshot(cars);

        // when
        List<String> expectedCarNames = List.of("pobi", "woni", "jun");

        // then
        assertThat(carRaceSnapshot.getMaxDistanceCarsName()).isEqualTo(expectedCarNames);

    }
}