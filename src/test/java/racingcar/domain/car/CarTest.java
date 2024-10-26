package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.AlwaysStopStrategy;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_전진_테스트() {
        int position = car.getPosition();
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();

        car.move(alwaysMoveStrategy);

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    void 자동차_정지_테스트() {
        int position = car.getPosition();
        MoveStrategy alwaysStopStrategy = new AlwaysStopStrategy();

        car.move(alwaysStopStrategy);

        assertThat(car.getPosition()).isEqualTo(position);
    }

}
