package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.ErrorCode.CAR_NAME_EMPTY;
import static racingcar.ErrorCode.CAR_NAME_LENGTH_EXCEEDED;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    private final int MOVE_FORWARD_CRITERION = 4;
    private final int MOVE_NOT_FORWARD_CRITERION = 3;
    @Test
    void 무작위_값이_4_이상이라면_전진한다() {
        // given
        Car car = new Car("pobi", new FixedAcceleration(MOVE_FORWARD_CRITERION));

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_4_미만이라면_거리는_변하지_않는다() {
        // given
        Car car = new Car("pobi", new FixedAcceleration(MOVE_NOT_FORWARD_CRITERION));

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외를_발생한다() {
        // given
        String carNames = "abcdef";

        // when & then
        Assertions.assertThatThrownBy(() -> new Car (carNames, new FixedAcceleration(MOVE_FORWARD_CRITERION)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_EXCEEDED.getMessage());
    }

    @Test
    void 자동차_이름이_비어있다면_예외를_발생한다() {
        // given
        String carNames = "";

        // when & then
        Assertions.assertThatThrownBy(() -> new Car(carNames, new FixedAcceleration(MOVE_FORWARD_CRITERION)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_EMPTY.getMessage());
    }
}
