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
    void 자동차_이름_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이름은 5자 이하만 가능합니다")
        );
    }


    @Test
    void 자동차_이름_빈값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 공백일 수 없습니다.")
        );
    }


    @Test
    void 경주_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 양의 정수여야 합니다.")
        );
    }

    @Test
    void 경주_횟수_숫자아님_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "three"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도할 횟수는 정수만 가능합니다.")
        );
    }

    @Test
    void 여러_자동차_경주_결과_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,crong", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "crong : -", "최종 우승자");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
