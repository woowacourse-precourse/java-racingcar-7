package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private final static int MOVABLE_VALUE = 4;
    private final static int IMMOVABLE_VALUE = 3;

    @Test
    void Car_생성_테스트() {
        // given
        Car car = new Car("pobi");

        // when, then
        assertAll(
            () -> assertThat(car).isNotNull(),
            () -> assertThat(car.getPosition()).isEqualTo(0)
        );
    }

    @Test
    void 차가_이동하면_position_1증가() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(MOVABLE_VALUE);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 차가_이동하면_position_1증가_여러번_시도() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(MOVABLE_VALUE);
        car.move(IMMOVABLE_VALUE);
        car.move(MOVABLE_VALUE);
        car.move(IMMOVABLE_VALUE);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
