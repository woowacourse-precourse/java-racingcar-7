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
                    .hasMessageContaining("레이싱카 이름의 길이는 5글자가 넘을 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트2_컴마이외의구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,ja;ka", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("',' 이외의 구분자를 사용할 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트3_attempt_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,kate", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 0 이하가 될 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트4_attempt_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,kate", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 0 이하가 될 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트5_이름이공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("레이싱카 이름은 공백일 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트6_이름사이공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, w o", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("레이싱카 이름에 공백이 포함될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
