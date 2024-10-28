package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarTest {
	@Test
    void 자동차_이동_성공() {
        Car car = new Car("test");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이동_실패() {
        Car car = new Car("test");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
