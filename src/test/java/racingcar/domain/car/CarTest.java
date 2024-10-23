package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("전진할 수 있는 조건일 경우, 자동차는 전진한다.")
    void givenCanForwardCondition_whenForward_thenCarForward() {
        // given
        Car car = new Car("car", new Condition(() -> 4));
        int beforePosition = car.getPosition();

        // when
        car.forward();

        // then
        assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("전진할 수 없는 조건일 경우, 자동차는 정지한다.")
    void givenCanNotForwardCondition_whenForward_thenCarStop() {
        // given
        Car car = new Car("car", new Condition(() -> 3));
        int beforePosition = car.getPosition();

        // when
        car.forward();

        // then
        assertThat(car.getPosition()).isEqualTo(beforePosition);
    }

}