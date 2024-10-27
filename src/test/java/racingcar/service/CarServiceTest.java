package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {
    @DisplayName("자동차 이름의 길이가 5 초과인 경우 IllegalArgumentException 발생")
    @Test
    void carNameLengthOver5() {
        assertThatThrownBy(() -> new CarService().createGame("car,name,carName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}
