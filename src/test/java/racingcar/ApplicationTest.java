package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 기능_테스트_다른_이름() {
        assertRandomNumberInRangeTest(
            () -> {
                run("alice,bob", "1");
                assertThat(output()).contains("alice : -", "bob : ", "최종 우승자 : alice");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 여러_라운드_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "3");
                assertThat(output()).contains(
                    "pobi : ---",
                    "woni : --",
                    "최종 우승자 : pobi"
                );
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    void 빈_입력_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "a"})
    void 라운드_숫자_유효성_테스트(String invalidInput) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 플레이어_이름_중복_테스트() {
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
