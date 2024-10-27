package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("전체 기능이 잘 작동하는지 확인한다")
    void basicApplicationTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hb", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hb : ", "최종 우승자 : pobi, woni, hb");
                },
                1, 1, 1
        );
    }


    @Test
    @DisplayName("예외를 적절히 발생시키는지 확인한다")
    void basicApplicationExceptionTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po  bi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
