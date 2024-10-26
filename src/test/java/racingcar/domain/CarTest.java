package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 출력_시_이름과_이동을_함께_출력한다() {
        Car car = new Car("상원");

        car.move();
        car.move();

        assertThat(car.toString()).isEqualTo("상원 : --");
    }
}