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
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "3");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트2_이름공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,        woni     ", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트3_우승자여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,java,kate", "3");
                    assertThat(output()).contains("pobi : -", "java : -", "kate : ", "최종 우승자 : pobi, java");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트1_이름길이제한() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2_컴마이외의구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java;kate", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // ','가 아닌 다른 문자가 있을 경우

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
