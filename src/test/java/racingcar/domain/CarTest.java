package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 생성() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void 이름_길이_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("abcdef"))
                .withMessageMatching("자동차 이름은 5자 이하여야 합니다");
    }

}
