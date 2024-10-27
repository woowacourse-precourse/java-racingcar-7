package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("pobi");

        car.move();  // car의 move()가 무작위 값을 사용하도록 한다면 별도 인자 없이 호출

        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
