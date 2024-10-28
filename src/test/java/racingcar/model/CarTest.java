package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_BLANK_ERROR;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.common.exception.ErrorMessage.CAR_NAME_NULL_ERROR;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_5자_이하의_이름을_가진다() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertEquals(name, car.getName());
    }

    @Test
    void 자동차의_이름이_5자를_초과하는_경우_예외_처리한다() {
        // given
        String name = "엄청 빠른 차";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @Test
    void 자동차의_이름이_null인_경우_예외_처리한다() {
        // given
        String name = null;

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NULL_ERROR);
    }

    @Test
    void 자동차의_이름이_공백으로만_구성된_경우_예외_처리한다() {
        // given
        String name = "     ";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_BLANK_ERROR);
    }
}