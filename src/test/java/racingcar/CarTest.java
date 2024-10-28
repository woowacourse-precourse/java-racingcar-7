package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("정상적인 자동차 이름으로 Car 객체 생성한다.")
    @Test
    void testValidCarName() {
        Car car = new Car("pobi");
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0); // 초기 위치는 0이어야 함
    }
    @DisplayName("자동차 이름이 빈 값일 경우 예외가 발생한다.")
    @Test
    void testEmptyCarName() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @DisplayName("자동차 이름이 5글자 초과일 경우 예외가 발생한다.")
    @Test
    void testCarNameTooLong() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }
}