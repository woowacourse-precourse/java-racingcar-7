package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름이 빈칸이나 5글자를 초과할 수 없다.")
    @Test
    void 자동차_이름_길이_에러() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
