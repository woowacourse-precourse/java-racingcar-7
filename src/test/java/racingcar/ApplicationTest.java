package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ExceptionMessages;

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

    @ParameterizedTest
    @DisplayName("양의 정수 형식이 아닌 라운드 입력에 대한 예외 테스트")
    @ValueSource(strings = {"a", "-1", "three", " ", "1.5"})
    void invalidRoundInputTest(String invalidInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessages.INVALID_NUMBER_FORMAT.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
