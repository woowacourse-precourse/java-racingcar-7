package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void 자동차_이름이_없을_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.from(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
