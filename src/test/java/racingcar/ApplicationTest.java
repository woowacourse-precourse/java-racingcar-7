package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("올바른 문자열과 시도 횟수가 입력되었을 때, 올바른 값이 입력된다.")
    @Test
    void Given_CorrectInputANDROUNDS_When_GameStart_Then_Success() {
        // Given
        // When
        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "1");
                    assertThat(output()).contains("a : -", "b : -", "c : ", "최종 우승자 : a, b");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("빈 문자열과 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_EmptyString_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("문자열 하나와 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_OneNames_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("문자열 하나와 쉼표 그리고 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_OneNamesWithComma_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표 두개가 연속으로 입력되고 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_ConsecutiveComma_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복된 이름과 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_DuplicatedName_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,a,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("5자 이상의 이름이 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_NameLengthOverFive_When_CheckNames_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,bb,ffffff", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("문자열과 숫자 아닌 값이 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_NonNumericRounds_When_CheckRounds_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,bb", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("문자열과 음수가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_NegativeRounds_When_CheckRounds_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,bb", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("문자열과 정수 범위 이상의 숫자가 들어갔을 때, 에러 메시지가 출력된다.")
    @Test
    void Given_NotIntegerRange_When_CheckRounds_Then_Error() {
        // Given
        // When
        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a, bb, ccc", "Integer.MAX_VALUE"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
