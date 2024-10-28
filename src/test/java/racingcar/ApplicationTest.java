package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("입력이 공백이면 예외")
    @CsvSource({
            "'', '1'",
            "' ', '1'",
            "'pobi,wani', ' '",
    })
    void throwExceptionIfInputIsBlank(String carNamesInput, String totalRoundInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNamesInput, totalRoundInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("차량 이름이 비어 있거나, 공백을 포함하면 예외")
    @CsvSource({
            "'pobi, wani', '3'",
            "'pobi, ,wani', '3'",
            "',', '3'",
            "'pobi,,wani', '3'",
            "'pobi,wani,', '3'"
    })
    void throwExceptionIfCarNameContainsBlank(String carNamesInput, String totalRoundInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNamesInput, totalRoundInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
