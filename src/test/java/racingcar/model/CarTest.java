package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.MockRandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Car 테스트")
public class CarTest {
    @Test
    void 자동차_이름_길이_검증() {
        RandomNumberGenerator mockGenerator = new MockRandomNumberGenerator(4);
        assertThatThrownBy(() -> new Car("abcdef", mockGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_공백_검증() {
        RandomNumberGenerator mockGenerator = new MockRandomNumberGenerator(4);
        assertThatThrownBy(() -> new Car("", mockGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_전진_테스트() {
        RandomNumberGenerator mockGenerator = new MockRandomNumberGenerator(4);
        Car car = new Car("pobi", mockGenerator);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_정지_테스트() {
        RandomNumberGenerator mockGenerator = new MockRandomNumberGenerator(3);
        Car car = new Car("pobi", mockGenerator);
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
