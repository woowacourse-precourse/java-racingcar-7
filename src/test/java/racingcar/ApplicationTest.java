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
    void 기능_테스트_2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("jenna ,ryan ,jason", "5");
                assertThat(output()).contains(
                    "jenna : -", "ryan : ", "jason : ",
                    "jenna : --", "ryan : ", "jason : ",
                    "jenna : --", "ryan : ", "jason : -",
                    "jenna : --", "ryan : -", "jason : -",
                    "jenna : --", "ryan : -", "jason : --",
                    "최종 우승자 : jenna, jason"
                );
            },
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP,
            STOP, STOP, MOVING_FORWARD,
            STOP, MOVING_FORWARD, STOP,
            STOP, STOP, MOVING_FORWARD
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
    void 자동차_이름_유효성_테스트_1_빈값_1() {
        assertThatThrownBy(() -> runException("", "4"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 이름은 허용되지 않습니다");
    }

    @Test
    void 자동차_이름_유효성_테스트_1_빈값_2() {
        assertThatThrownBy(() -> runException("test, test1, , test7", "4"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 이름은 허용되지 않습니다");
    }

    @Test
    void 자동차_이름_유효성_테스트_2_정규식() {
        assertThatThrownBy(() -> runException("jenna, jason, summer, ryan", "3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 영문, 한글, 숫자로 이루어진 5자 이하의 문자열만 허용됩니다");
    }

    @Test
    void 자동차_이름_유효성_테스트_3_중복() {
        assertThatThrownBy(() -> runException("luna, david, jay, luna", "3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 이름은 허용되지 않습니다");
    }

    @Test
    void 라운드_수_유효성_테스트_1_0() {
        assertThatThrownBy(() -> runException("jenna, jason", "0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수가 적절하지 않습니다");
    }

    @Test
    void 라운드_수_유효성_테스트_2_음수() {
        assertThatThrownBy(() -> runException("jenna, jason", "-3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수가 적절하지 않습니다");
    }

    @Test
    void 라운드_수_유효성_테스트_1_문자열() {
        assertThatThrownBy(() -> runException("jenna, jason", "gogo"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자를 입력해주세요");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
