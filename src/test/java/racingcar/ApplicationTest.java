package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;
import racingcar.model.ErrorType;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("공백, 개행문자, tab 와같은 빈 문자열 입력시 예외 처리")
    void 빈_문자열_입력_예외_처리() {
        assertThatThrownBy(() -> runException(" ","","     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorType.INPUT_NULL_ERROR.getMessage());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
