package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름이_빈문자열일때_예외() {
        assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열이거나 공백일 수 없습니다.");
    }

    @Test
    void 자동차이름에_공백이_포함될때_예외() {
        assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열이거나 공백일 수 없습니다.");
    }

    @Test
    void 자동차이름이_5자를_초과할때_예외() {
        assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다: javaji");
    }

    @Test
    void 시도횟수가_1미만일때_예외() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1 이상 10 이하의 정수여야 합니다.");
    }

    @Test
    void 시도횟수가_10초과할때_예외() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "11"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1 이상 10 이하의 정수여야 합니다.");
    }

    @Test
    void 중복된자동차이름이_있을때_예외() {
        assertThatThrownBy(() -> runException("pobi,pobi,jun", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다: pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
