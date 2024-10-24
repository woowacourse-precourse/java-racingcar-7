package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.CarFixture.createCar;

@DisplayName("자동차 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차가 랜덤 숫자 4이상을 가지면 움직인다.")
    void test_car_is_move_when_random_is_over_4() {

        // given
        Car car = createCar();

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
