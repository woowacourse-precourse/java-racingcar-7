package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 생성() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
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

    @Test
    void 더_큰_위치() {
        Car car = new Car("pobi", 4);
        assertThat(car.comparePosition(3)).isEqualTo(4);
    }

    @Test
    void 같은_위치() {
        Car car = new Car("pobi", 3);
        assertThat(car.isSameForward(3)).isTrue();
        assertThat(car.isSameForward(2)).isFalse();
    }

    @Test
    void to_string() {
        Car car = new Car("pobi", 1);
        assertThat(car.toString()).isEqualTo("pobi : -");
    }
}
