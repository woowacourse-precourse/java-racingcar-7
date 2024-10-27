package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.FixedMoveStrategy;

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
}