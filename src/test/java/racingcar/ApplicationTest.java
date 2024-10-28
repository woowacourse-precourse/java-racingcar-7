package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 음수_시도횟수_예외_테스트() {
        String string = "-1";
        assertThatThrownBy(() -> {
            Validator.validateTrialCount(string);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 음수가 될 수 없습니다.");
    }
    @Test
    void 이름_빈칸_예외_테스트() {
        assertThatThrownBy(() -> {
            Validator.validateCarNames("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 비어있습니다.");
    }
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
