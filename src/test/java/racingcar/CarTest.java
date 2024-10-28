package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 이동_성공_테스트() {
        Car car = new Car("pobi", () -> true); // 항상 이동하는 전략
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이동_실패_테스트() {
        Car car = new Car("pobi", () -> false); // 이동하지 않는 전략
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름_유효성_검사_테스트() {
        assertThatThrownBy(() -> new Car("javaji", () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자만 가능합니다.");

        assertThatThrownBy(() -> new Car("", () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자만 가능합니다.");
    }
}
