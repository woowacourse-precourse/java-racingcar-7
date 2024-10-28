package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Attempts;
import racingcar.domain.CarName;

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
    void 우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains(
                            "최종 우승자 : pobi,woni"
                    );
                },
                // 첫 번째 시도
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                // 두 번째 시도
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트_자동차_이름_길이_초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름의 길이는 5 이하여야만 합니다");
        });
    }

    @Test
    void 예외_테스트_자동차_이름_중복() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 중복될 수 없습니다");
        });
    }

    @Test
    void 예외_테스트_시도_횟수_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 할 횟수는 1 이상의 정수여야 합니다");
        });
    }

    @Test
    void 예외_테스트_시도_횟수_숫자아님() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "three"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 할 횟수는 1 이상의 정수여야 합니다");
        });
    }

    @Test
    void 빈_자동차_이름_예외_테스트() {
        assertThatThrownBy(() -> new CarName("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 비어있을 수 없습니다.");
    }

    @Test
    void 시도횟수_공백_예외_테스트() {
        assertThatThrownBy(() -> new Attempts("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 할 횟수는 1 이상의 정수여야 합니다");
    }

    @Test
    void 예외_테스트_시도_횟수_0() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 할 횟수는 1 이상의 정수여야 합니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
