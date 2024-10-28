package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_회수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", ""))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자가_없는_경우_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : 없음");
            },
                STOP, STOP
        );
    }

    @Test
    void 우승자가_한_명_이상인_경우_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 우승자가_한_명인_경우_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 문자_유효성_컴마_시작_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",pobi,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_유효성_컴마_종료_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_유효성_컴마_연속_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_유효성_점_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_길이_유효성_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,wonijavaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
