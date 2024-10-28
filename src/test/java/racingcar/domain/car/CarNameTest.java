package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Nested
    class CarName_검증_테스트 {
        @Test
        void 자동차_이름이_5자를_초과할_경우_예외_발생() {
            assertThatThrownBy(() -> CarName.from("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_이름이_공백일_경우_예외_발생() {
            assertThatThrownBy(() -> CarName.from(" "))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
