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
    void should_DisplayMultipleWinnersSeparatedByComma() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("혼자 참여한 경우 언제나 우승자다.")
    void should_DeclareSingleCarAsWinnerWhenOnlyOneParticipant() {
        assertSimpleTest(() -> {
            run("pobi", "3");
            assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
        });
    }

    @Test
    @DisplayName("모두가 움직이지 않은 경우에도 우승자는 출력된다.")
    void should_DisplayWinnersWhenNoCarsMove() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "abcdef", "longname", "123456" })
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다.")
    void should_ThrowExceptionWhenCarNameExceedsMaxLength(String longName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(longName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "포비", "p@bi", "pobi!", "po bi" })
    @DisplayName("경주할 자동차 이름에 유효하지 않은 문자가 포함된 경우 예외가 발생한다.")
    void should_ThrowExceptionForInvalidCharactersInCarNames(String testCarName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(testCarName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이거나 공백인 경우 예외가 발생한다.")
    void should_ThrowExceptionForEmptyOrBlankCarNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, , jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름에 중복된 이름이 포함된 경우 예외가 발생한다.")
    void should_ThrowExceptionForDuplicateCarNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수에 숫자가 아닌 값이 입력된 경우 예외가 발생한다.")
    void should_ThrowExceptionWhenNonNumericTryCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수가 1보다 작은 경우 예외가 발생한다.")
    void should_ThrowExceptionWhenRaceRoundCountIsLessThan1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { " 1", "1 ", " 1 " })
    @DisplayName("시도할 횟수를 입력할 때 좌우 공백이 포함되더라도 예외가 발생하지 않는다.")
    void should_NotThrowExceptionWhenRaceRoundCountHasLeadingOrTrailingWhitespace(String raceRoundCount) {
        assertSimpleTest(() -> {
            run("pobi,woni", raceRoundCount);  // 공백을 제거하고 실행
            assertThat(output()).contains("최종 우승자");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 0", " 1 0", "1 0 ", " 1 0 " })
    @DisplayName("시도할 횟수를 입력할 때 숫자 사이에 공백이 포함된 경우 예외가 발생한다.")
    void should_ThrowExceptionWhenRaceRoundCountHasInternalWhitespace(String raceRoundCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", raceRoundCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
