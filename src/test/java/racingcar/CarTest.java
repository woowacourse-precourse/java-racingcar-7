package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    void 무작위_값이_4_이상이라면_전진한다() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_4_미만이라면_거리는_변하지_않는다() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
