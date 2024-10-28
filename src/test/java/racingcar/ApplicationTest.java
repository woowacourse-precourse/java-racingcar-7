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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_마지막_이름이_공백으로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_중간_이름이_공백으로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,aasd", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_처음_이름이_공백으로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",aasd", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_반복_횟수가_0으로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수가_음수로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수가_정수와_공백이_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "5 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수가_소수로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "1.2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수가_문자로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수가_특수문자로_입력되었을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_반복_횟수는_일만번을_넘지않는다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "10001"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
