package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 입력이_비어있을때_예외_발생() {
        assertThatThrownBy(() -> InputView.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
