package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.AlwaysStopStrategy;

public class CarTest {

    private Car car;
    private MoveStrategy alwaysMoveStrategy;
    private MoveStrategy alwaysStopStrategy;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        alwaysMoveStrategy = new AlwaysMoveStrategy();
        alwaysStopStrategy = new AlwaysStopStrategy();
    }

    @Test
    void 자동차_전진_테스트() {
        int position = car.getPosition();

        car.move(alwaysMoveStrategy);

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    void 자동차_정지_테스트() {
        int position = car.getPosition();

        car.move(alwaysStopStrategy);

        assertThat(car.getPosition()).isEqualTo(position);
    }

}
