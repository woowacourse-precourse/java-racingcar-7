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
    @DisplayName("공동 우승자가 여럿인 경우 쉼표(,)로 구분한다.")
    void displayMultipleWinnersSeparatedByComma() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("alpha,beta", "1");
                    assertThat(output()).contains("alpha : -", "beta : -", "최종 우승자 : alpha, beta");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("혼자 참여한 경우 언제나 우승자다.")
    void declareSingleCarAsWinnerWhenOnlyOneParticipant() {
        assertSimpleTest(() -> {
            run("gamma", "3");
            assertThat(output()).contains("gamma : ", "최종 우승자 : gamma");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "abcdef", "longname", "123456" })
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다.")
    void throwExceptionWhenCarNameExceedsMaxLength(String longName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(longName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "베타", "c@ar", "car!", "ca r" })
    @DisplayName("경주할 자동차 이름에 유효하지 않은 문자가 포함된 경우 예외가 발생한다.")
    void throwExceptionForInvalidCharactersInCarNames(String testCarName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testCarName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
