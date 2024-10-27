package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차의 현재 이동거리를 입력받은 문자로 표현한다")
    void showCurrentCarPositionalStatusTest() {
        // given
        Car car = Car.from("test");
        String symbol = "-";
        int value = 5;
        // when
        car.tryMoveForward(value, 1);
        String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(symbol);

        // then
        assertThat(currentPositionalVisualStatus).isEqualTo("test" + " : " + "-");
    }
}