package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ValidateCountTest extends NsTest {

    @Test
    void 예외_테스트_빈문자열() {
        assertThatThrownBy(() -> ValidateCount.validateInputCount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_음수가들어온경우() {
        assertThatThrownBy(() -> ValidateCount.validateInputCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_자연수가아닌값() {
        assertThatThrownBy(() -> ValidateCount.validateInputCount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}