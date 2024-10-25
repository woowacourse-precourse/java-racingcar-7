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
    void 우승자_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "jun : --", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi123,woni,jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 최대 5자까지 입력 가능합니다.")
        );
    }

    @Test
    void 자동차_이름_공백만_있는_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,woni,jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 공백일 수 없습니다.")
        );
    }

    @Test
    void 이동_횟수_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 이동 횟수입니다. 양의 정수를 입력해주세요.")
        );
    }

    @Test
    void 이동_횟수_숫자_아닌_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "three"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 이동 횟수입니다. 양의 정수를 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}