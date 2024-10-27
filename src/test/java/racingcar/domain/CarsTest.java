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


}
