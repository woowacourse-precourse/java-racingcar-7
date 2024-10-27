package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarValidatorTest {

    @Test
    void 자동차_이름_5자_이상() {
        assertThatThrownBy(() -> {
            CarValidator.carNameLength("123456");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 5자를 넘습니다.");
    }

    @Test
    void 자동차_이름_공백() {
        assertThatThrownBy(() -> {
            CarValidator.carNameEmpty("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름으로 공백은 불가능합니다.");
    }
}