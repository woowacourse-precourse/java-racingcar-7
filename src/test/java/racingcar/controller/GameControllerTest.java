package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.config.AppConfig;

class GameControllerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        AppConfig.getAppConfig().reset();
    }

    @Test
    void 정상_입력_단일_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP
        );
    }

    @Test
    void 정상_입력_공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobipobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 자동차_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 서로 중복될 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_공백_포함_가능_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni, jun", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_공백_포함_가능_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,woni   ,jun   ", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_공백_포함_가능_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi , woni  ,   jun", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_공백_포함_가능_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_이름_공백_포함_불가능_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름이 공백일 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_공백_포함_불가능_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름이 공백일 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_공백_포함_불가능_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름이 공백일 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_공백_포함_불가능_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" , , ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름이 공백일 수 없습니다.")
        );
    }

    @Test
    void 자동차_최소_1대_이상_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 한 대 이상의 자동차가 필요합니다.")
        );
    }

    @Test
    void 자동차_최소_1대_이상_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 한 대 이상의 자동차가 필요합니다.")
        );
    }

    @Test
    void 자동차_최소_1대_이상_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 한 대 이상의 자동차가 필요합니다.")
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_실수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1.4"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_int_범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "2147483648"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_문자열_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "five"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 잘못된_입력_시도_횟수_문자열_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "3a"))
                        .isInstanceOf(NumberFormatException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}