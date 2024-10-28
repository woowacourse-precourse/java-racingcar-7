package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_자동차_이름을_포함하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_0글자인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_5글자_초과인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,banana", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_1글자_이상_5글자_이하인_경우() {
        assertSimpleTest(() ->
                assertThatCode(() -> run("pobi,cool,sun", "4")).doesNotThrowAnyException()
        );
    }

    @Test
    void 자동차_이름의_첫_글자가_영문자로_시작하지_않는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름의_첫_글자가_영문자로_시작하는_경우() {
        assertSimpleTest(() ->
                assertThatCode(() -> run("Sun", "4")).doesNotThrowAnyException()
        );
    }

    @Test
    void 자동차_이름이_쉼표로만_구성된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름을_입력하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_영문자와_숫자로만_구성되지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_영문자와_숫자로만_구성된_경우() {
        assertSimpleTest(() ->
                assertThatCode(() -> run("a2b", "2")).doesNotThrowAnyException()
        );
    }

    @Test
    void 시도_횟수가_0인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("apple,mango", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수를_입력하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("apple,mango", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("apple,mango", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
