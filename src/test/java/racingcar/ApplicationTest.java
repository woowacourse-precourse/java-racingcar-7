package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("사용자의 이름이 너무 긴 경우")
    void testToLongRacerName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaaaaaaaa,a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("length of string's is over")
        );
    }

    @Test
    @DisplayName("사용자의 이름이 공백인 경우")
    void testBlankRacerName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("name cannot be blank")
        );
    }

    @Test
    @DisplayName("사용자가 없는 경우")
    void testNoRacer() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("racer must more than one")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("이동 횟수가 양수가 아닌 경우")
    void testPlayCountIsPositiveNumber(String count) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb,c", count))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("count must be greater than 0")
        );
    }

    @Test
    @DisplayName("중복된 사용자 이름")
    void testDuplicateRacerName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,aa", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("duplicate names included")
        );
    }

    @Test
    @DisplayName("너무 큰 횟수 입력")
    void testPlayOverIntegerMax() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "999999999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("number out of range for type long:")
        );
    }

    @Test
    @DisplayName("횟수 입력에 숫자가 아닌 문자가 있는 경우")
    void testNonNumericTypeOfCountInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b", "c"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("invalid number format:")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
