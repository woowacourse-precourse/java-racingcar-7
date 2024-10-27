package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("이름이 5자 이상인 경우 예외를 발생한다.")
    void validateName() {
        Assertions.assertThatThrownBy(() -> new Name("우테코우테코"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하여야 합니다.");
    }

}