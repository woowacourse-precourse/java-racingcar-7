package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름으로_자동차를_생성() {
        Car car = new Car("pobi");

        assertThat(car.getName())
                .isEqualTo("pobi");
    }

    @Test
    void 자동차_이름이_5자보다_많으면_예외() {
        assertThatThrownBy(() ->
                new Car("overlength"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_EXCEPTION.message());
    }
}
