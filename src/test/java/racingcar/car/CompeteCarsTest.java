package racingcar.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveRandomlyStrategy;
import racingcar.strategy.MoveStrategy;

class CompeteCarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final MoveStrategy moveStrategy = new MoveRandomlyStrategy();

    @Test
    void duplicatedCarTest() {
        assertThatThrownBy(() -> new CompeteCars(List.of("test", "test")));
    }

    @Test
    void getCarsCurrentPosition() {
        CompeteCars cars = new CompeteCars(List.of("test"));

        assertRandomNumberInRangeTest(() -> {
            cars.moveAll(moveStrategy);
            StringBuilder moveResult = new StringBuilder();
            cars.getCarsCurrentPosition().forEach((name, position) -> {
                moveResult.append(name).append(position);
            });
            assertThat(moveResult.toString()).isEqualTo("test1");
        }, MOVING_FORWARD);
    }

    @Test
    void getCarsMaxPosition() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));

        assertRandomNumberInRangeTest(() -> {
            cars.moveAll(moveStrategy);
            cars.moveAll(moveStrategy);
            assertThat(cars.getCarsMaxPosition()).isEqualTo(2);
        }, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }

    @Test
    void getWinnerCars() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        MoveStrategy moveStrategy = new MoveRandomlyStrategy();

        assertRandomNumberInRangeTest(() -> {
            cars.moveAll(moveStrategy);
            assertThat(cars.getWinnerCars()).contains("test");
        }, MOVING_FORWARD, STOP);
    }
}