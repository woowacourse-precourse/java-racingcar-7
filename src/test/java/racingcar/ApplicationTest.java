package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"jenn:1", "jenn,:1", "jenn,kelly,jenn:1"}, delimiter = ':')
    @DisplayName("자동차 이름을 올바르게 입력하지 않은 경우 예외가 발생하는지 검사")
    void validateSeperatorPresent(String name, String count) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, count))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"jenn, jun:k", "jenn, jun:0"}, delimiter = ':')
    @DisplayName("실행 횟수가 양수가 아닌 경우 예외가 발생하는지 검사")
    void validateGameCountIsNumber(String name, String count) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(name, count))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 이상의 숫자를 입력해 주세요.")
        );
    }

    @DisplayName("우승자가 여러 명일 때 쉼표로 구분하여 출력하는지 검사")
    @Test
    void validateWinnersCommaSeperated() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("jenn, kelly, jun", "2");
                    assertThat(output()).contains("jenn : --", "kelly : --", "jun : -", "최종 우승자 : jenn, kelly");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
