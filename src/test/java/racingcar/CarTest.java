package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차가 전진하면 위치가 1 늘어난다.")
    @Test
    void moveForwardTest() {
        // given
        Car car = new Car("test");

        // when
        car.moveForward();

        // then
        assertThat(car.isPositionSameAs(1)).isTrue();
    }

    @DisplayName("현재 위치를 바탕으로 결과 메시지를 반환한다.")
    @Test
    void convertCurrentStateToStringTest() {
        // given
        Car car = new Car("test");
        car.moveForward();

        // when
        String string = car.convertCurrentStateToString();

        // then
        assertThat(string).hasToString("test : -");
    }
}