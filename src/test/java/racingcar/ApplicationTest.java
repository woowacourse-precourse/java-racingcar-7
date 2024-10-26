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
    void 정상_기능() {
        assertRandomNumberInRangeTest(
            () -> {
                run("eunho,woni", "1");
                assertThat(output()).contains("eunho : -", "woni : ", "최종 우승자 : eunho");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 긴_이름() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,over5w", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",eunho", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_자동차_이름() {
        assertRandomNumberInRangeTest(
            () -> {
                run("1,2", "1");
                assertThat(output()).contains("1 : -", "2 : ", "최종 우승자 : ");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 특수문자_이름() {
        assertRandomNumberInRangeTest(
            () -> {
                run("*,;,:", "2");
                assertThat(output()).contains("* : -", "; : ", ": : ", "최종 우승자 : ");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이스케이프시퀀스_이름() {
        assertRandomNumberInRangeTest(
            () -> {
                run("*,;,:", "2");
                assertThat(output()).contains("* : -", "; : ", ": : ", "최종 우승자 : ");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 중복되는_이름() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunho,eunch", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수값_초과하는_이동횟수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunch,doyeo", "2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 수식() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunch,doyeo", "1+2+3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunch,doyeo", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 영회_시도횟수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunch,doyeo", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_시도횟수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("eunho,eunch,doyeo", "'0'"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
