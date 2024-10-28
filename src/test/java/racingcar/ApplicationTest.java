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
    void 기본_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 모든_자동차_멈춤_테스트() {
        // 모든 자동차가 멈추는 상황 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 공동_우승자_테스트() {
        // 두 명 이상의 자동차가 동일 거리를 이동해 공동 우승자가 발생하는 상황 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 복수_회_이동_테스트() {
        // 이동 횟수가 3인 경우 테스트하여 여러 회차의 이동이 올바르게 동작하는지 확인
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_5자_초과_예외_테스트() {
        // 자동차 이름이 5자를 초과할 때 예외가 발생하는지 테스트
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈_문자열_입력_예외_테스트() {
        // 빈 문자열을 자동차 이름으로 입력했을 때 예외가 발생하는지 테스트
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이동_횟수_숫자_아님_예외_테스트() {
        // 이동 횟수에 숫자가 아닌 값이 입력되었을 때 예외가 발생하는지 테스트
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "one"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이동_횟수_음수_예외_테스트() {
        // 이동 횟수에 음수가 입력되었을 때 예외가 발생하는지 테스트
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
