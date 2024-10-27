package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

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
    void 동점자_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 모두_움직이지_않았을_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage())
        );
    }

    @Test
    void 자동차_이름을_입력하지_않고_쉼표를_적었는지() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,b"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.MISSING_CAR_NAME.getMessage())
        );
    }

    @Test
    void 자동차_이름_입력값이_존재하지_않을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    void 자동차_이름을_입력하고_쉼표로_끝냈는지() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.UNEXPECTED_COMMA.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
