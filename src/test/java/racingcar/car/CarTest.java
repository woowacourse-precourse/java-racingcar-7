package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.global.constant.Config.MAX_CAR_NAME_SIZE;
import static racingcar.global.constant.ErrorMessage.CAR_NAME_OVERSIZE_ERROR_MESSAGE;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_이름_짓기() {
        //given
        String name = "test";
        //when
        Car car = new Car(name);
        //then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 이름이_최대_길이를_초과할_경우_예외_발생() {
        //given
        String name = "A".repeat(MAX_CAR_NAME_SIZE + 1);
        //when
        // then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_OVERSIZE_ERROR_MESSAGE);
    }

}