package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ValidateCountTest extends NsTest {

    @Test
    void 예외_테스트_빈문자열() {
        assertThatThrownBy(() -> ValidateCount.parseCount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_음수가들어온경우() {
        assertThatThrownBy(() -> ValidateCount.parseCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_자연수가아닌값() {
        assertThatThrownBy(() -> ValidateCount.parseCount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}