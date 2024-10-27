package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.global.message.ErrorMessage;
import racingcar.model.Cars;


class CarsTest {

    @Test
    void 중복된_자동차_이름_예외() {
        assertThatThrownBy(() -> Cars.createCarList("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    void 연속된_구분자_입력_예외() {
        assertThatThrownBy(() -> Cars.createCarList("pobi,,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONSECUTIVE_COMMAS.getMessage());
    }

    @Test
    void 빈_이름_입력_예외() {
        assertThatThrownBy(() -> Cars.createCarList("pobi, ,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }
}
