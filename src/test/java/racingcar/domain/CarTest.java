package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 생성() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void 이름_길이_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("abcdef"))
                .withMessageMatching("자동차 이름은 5자 이하여야 합니다");
    }

    @Test
    void 전진() {
        Car car = new Car("pobi", 0);
        assertThat(car.move(4)).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        Car car = new Car("pobi", 0);
        assertThat(car.move(3)).isEqualTo(new Car("pobi", 0));
    }
}
