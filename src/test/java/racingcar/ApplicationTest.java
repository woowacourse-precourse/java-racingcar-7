package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    /**
     * 예외 테스트
     */
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_5자를_초과하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,abcdef", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하여야 합니다: ")
        );
    }

    @Test
    void 숫자가_아닌_시도횟수가_입력되는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 '한 개'의 '숫자'여야 합니다. ")
        );
    }

    @Test
    void 자동차_이름이_빈_문자열인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 빈 문자열일 수 없습니다.")
        );
    }

    @Test
    void 둘_이상의_자동차_이름이_중복될_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,a,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름에 중복이 존재합니다: ")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
