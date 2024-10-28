package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_이름을_가진다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_5글자_초과시_예외발생() {
        assertThatThrownBy(() -> new Car("javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_전진_한다() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_랜덤값이_4이상일때만_전진한다() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}