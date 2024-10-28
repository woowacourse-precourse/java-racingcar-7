package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.ErrorMessage.CAR_NAME_BLANK;
import static racingcar.domain.ErrorMessage.CAR_NAME_CONTAIN_SPECIAL_CHARACTER;
import static racingcar.domain.ErrorMessage.CAR_NAME_MAX;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름길이_범위_초과_예외처리() {

        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_MAX.getMessage());
    }

    @Test
    void 자동차_이름_공백_예외처리() {

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_BLANK.getMessage());
    }

    @Test
    void 자동차_이름길이_특수문자_예외처리() {

        assertThatThrownBy(() -> new Car("%%"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_CONTAIN_SPECIAL_CHARACTER.getMessage());
    }

    @Test
    void 자동차_이름길이_특수문자_포함_예외처리() {

        assertThatThrownBy(() -> new Car("%%현대"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_CONTAIN_SPECIAL_CHARACTER.getMessage());
    }


}