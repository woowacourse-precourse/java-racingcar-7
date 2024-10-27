package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.validator.GameValidator;

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
    void 이름에_공백이_포함된_경우_예외_테스트() {
        assertSimpleTest(() ->
        assertThatThrownBy(() -> GameValidator.validateCarName("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백이 포함될 수 없습니다.")
        );
    }

    @Test
    void 이름이_5글자_초과하는_경우_예외_테스트() {
        assertSimpleTest(() ->
        assertThatThrownBy(() -> GameValidator.validateCarName("javajava"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상 5자 이하로 입력해야 합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
