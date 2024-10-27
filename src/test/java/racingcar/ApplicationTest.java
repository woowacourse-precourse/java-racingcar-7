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
    void 극적으로_bbb가_3대4로_역전승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aaa,bbb", "5");
                    assertThat(output()).contains("aaa : ---", "bbb : ----", "최종 우승자 : bbb");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD
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
    void 입력값이_공백일수_없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름이 입력되지 않았습니다.")
        );
    }

    @Test
    void 자동차이름은_5자이하여야한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234,123456", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름을 5자 이하로 적어주세요.")
        );
    }

    @Test
    void 자동차이름은_공백일수없다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("  ,1234", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.")
        );
    }

    @Test
    void 시도횟수는_1회이상이여야한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa,bbb", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 시도횟수에_이상한값_들어온경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa,bbb", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 숫자여야 합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
