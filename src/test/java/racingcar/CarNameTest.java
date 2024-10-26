package racingcar;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void 자동차_이름의_길이가_5자_이하여야_한다() {
        assertThatNoException().isThrownBy(() -> new CarName("pobi"));
    }

    @Test
    void 자동차_이름의_길이가_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
