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
    void 예외_테스트_다중쉼표() {
        assertThatThrownBy(() -> runException("pobi,,java", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표 이전 또는 이후에 자동차 이름이 존재하지 않습니다");
    }

    @Test
    void 예외_테스트_시도횟수() {
        assertThatThrownBy(() -> runException("pobi,java", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수가 자연수가 아닙니다");
    }

    @Test
    void 예외_테스트_빈문자열() {
        assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 존재하지 않습니다");
    }

    @Test
    void 예외_테스트_쉼표만() {
        assertThatThrownBy(() -> runException(",,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 존재하지 않습니다");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
