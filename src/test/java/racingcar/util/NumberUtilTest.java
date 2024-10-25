package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NumberUtilTest {
    @Test
    void 시도_횟수_숫자_입력일_때() {
        assertThat(NumberUtil.toNumber("1")).isEqualTo(1);
    }

    @Test
    void 시도_횟수_숫자_입력_아닐_때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberUtil.toNumber("가"))
                .withMessageMatching("시도 횟수에는 숫자를 입력해야 합니다");
    }
}
