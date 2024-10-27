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
    void 특이한_이름_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("!!?,:::,:::4,!.5", "1");
                    assertThat(output()).contains("!!? : -", "::: : ",":::4 : ","!.5 : ", "최종 우승자 : !!?");
                },
                MOVING_FORWARD, STOP, STOP, STOP
        );
    }

    @Test
    void 입력_없음_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek,taek", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 후미_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek1,taek2, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek1, ,taek2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 선두_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,taek1,taek2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek1,taek2", "-11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek1,taek2", "3.67"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void int_범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("taek1,taek2", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
