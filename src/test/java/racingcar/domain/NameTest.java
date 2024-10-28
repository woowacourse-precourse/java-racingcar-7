package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

public class NameTest {
    @Test
    void 이름은_비어_있을수_없다() {
        assertThatThrownBy(() -> Name.newInstance("")).isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    void 이름은_5자_이하_이어야_한다() {
        assertThatThrownBy(() -> Name.newInstance("abcdef")).isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다.");
    }
}
