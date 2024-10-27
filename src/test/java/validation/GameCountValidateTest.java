package validation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.validation.Validation;

public class GameCountValidateTest {
    @Test
    void 시도횟수_문자_예외_테스트() {
        validAttemptException("a");
        validAttemptException("abc%");
    }

    @Test
    void 시도횟수_소수_예외_테스트() {
        validAttemptException("1.5");
    }

    @Test
    void 오버플로우_예외_테스트() {
        validAttemptException("2147483648");
    }

    @Test
    void 시도횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validation.validateGameCount("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수로는 시도 횟수를 측정하지 못합니다.")
        );
    }


    private void validAttemptException(String number) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validation.validateGameCount(number))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0~2^31-1의 정수로만 횟수를 입력하세요(문자, 소수 불가).")
        );
    }
}
