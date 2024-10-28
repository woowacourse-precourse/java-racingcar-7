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
    void 공동우승자_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("one,two,three", "4");
                    assertThat(output()).contains("one : --", "two : --", "three : --", "최종 우승자 : one, two, three");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP, STOP
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
    void 자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이름은 한 글자 이상 작성해 주세요.")
        );
    }

    @Test
    void 횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("one,two", "a3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("횟수는 정수만 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
