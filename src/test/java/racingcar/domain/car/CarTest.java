package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.FixedMoveStrategy;
import racingcar.domain.car.strategy.StopMoveStrategy;

class CarTest {
    @Test
    @DisplayName("이름 조회")
    void getName() {
        //given
        String expected = "testName";
        Car car = new Car(expected, new FixedMoveStrategy());

        //when
        String actual = car.getName();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치 조회")
    void getPosition() {
        //given
        Car car = new Car("testName", new FixedMoveStrategy());
        long expected = 0L;

        //when
        long actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치 이동 - 항상 이동하는 전략")
    void moveWithAlwaysMoveStrategy() {
        //given
        Car car = new Car("testName", new FixedMoveStrategy());
        long expected = 1L;

        //when
        car.move();

        //then
        long actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치 이동 - 항상 이동하지 않는 전략")
    void moveWithNeverMoveStrategy() {
        //given
        Car car = new Car("testName", new StopMoveStrategy());
        long expected = 0L;

        //when
        car.move();

        //then
        long actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }
}