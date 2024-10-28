package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    // 3. 자동차 이동 로직 테스트
    @Test
    void carShouldMoveWhenRandomValueIsFourOrMore() {
        Car car = new Car("test");
        car.move(4); // 4 이상일 경우 전진

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void carShouldNotMoveWhenRandomValueIsLessThanFour() {
        Car car = new Car("test");
        car.move(3); // 3 이하일 경우 멈춤

        assertThat(car.getDistance()).isEqualTo(0);
    }

}
