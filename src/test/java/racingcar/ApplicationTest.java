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
    void 입력_2명_반복_1번() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 입력_3명_반복_2번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hani", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "hani : --", "최종 우승자 : pobi, hani");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD

        );
    }

    @Test
    void 입력_4명_반복_2번_전체_이동() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hani,jun", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "hani : --", "jun : --", "최종 우승자 : pobi, woni, hani, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD

        );
    }

    @Test
    void 이름_5자_초과() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}