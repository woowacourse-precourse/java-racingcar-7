package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 기능_테스트_4이상이면_자동차_전진() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    void 기능_테스트_4미만이면_자동차_정지() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    void 예외_테스트_자동차이름_빈문자열_예외() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_CAR_NAME);
    }

    @Test
    void 예외_테스트_자동차이름_5자초과_예외() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_CAR_NAME);
    }

    @Test
    void 기능_테스트_자동차_생성() {
        Car car = new Car("abc");
        assertThat(car.getName()).isEqualTo("abc");
    }
}
