package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AttemptNumberTest {
    @Test
    void 시도_횟수에_문자_입력시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumber.from("세번 해볼래"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_음수_입력시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumber.from("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_0_입력시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumber.from("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
