package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름에 빈 문자열이 포함된 경우 예외가 발생한다.")
    @Test
    void newCarWithEmptyName() {
        assertThatThrownBy(() -> new Cars(List.of("pobi", "", "test")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @Test
    void newCarWithOutOfRange() {
        assertThatThrownBy(() -> new Cars(List.of("pobi", "pobipobi", "test")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }
}