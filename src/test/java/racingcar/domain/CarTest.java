package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.global.message.ErrorMessage;
import racingcar.model.Car;

class CarTest {
    @Test
    void 자동차_이름_길이_초과_예외() {
        assertThatThrownBy(() -> new Car("javajava"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }

    @Test
    void 자동차_이름_유효성_예외_알파벳이_아닌_경우() {
        assertThatThrownBy(() -> new Car("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_INVALID_CHARACTERS.getMessage());
    }
}
