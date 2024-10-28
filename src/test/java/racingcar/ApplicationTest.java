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
    void 이름앞뒤_공백은_허용() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,   woni  ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_여러명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni  ", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
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
    void 빈문자열이_입력된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_띄어쓰기한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Ann,D an,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수를_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Ann,Dan,pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_사이에_공백이_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Ann,Dan,pobi", "1 1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
