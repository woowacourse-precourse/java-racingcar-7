package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름을 입력받아 리스트로 반환한다.")
    void shouldReturnListOfCarNames() {
        // Given
        String input = "pobi,crong,honux";
        InputView inputView = new InputView();

        // When
        List<String> carNames = inputView.splitCarNames(input);

        // Then
        assertThat(carNames)
                .containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("잘못된 자동차 이름 입력 시 예외를 발생시킨다.")
    void shouldThrowExceptionForInvalidCarNames() {
        // Given
        List<String> invalidNames = Arrays.asList("tooLongName", " ", "");
        InputView inputView = new InputView();

        // When & Then
        for (String name : invalidNames) {
            assertInvalidCarNameThrowsException(inputView, name);
        }
    }

    private void assertInvalidCarNameThrowsException(InputView inputView, String name) {
        assertThatThrownBy(() -> inputView.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }

    @Test
    @DisplayName("시도할 횟수를 입력받아 정수로 반환한다.")
    void shouldReturnMoveCount() {
        // Given
        String input = "5";
        InputView inputView = new InputView();

        // When
        int moveCount = inputView.parseMoveCount(input);

        // Then
        assertThat(moveCount)
                .isEqualTo(5);
    }

    @Test
    @DisplayName("시도할 횟수에 숫자가 아닌 값을 입력하면 예외를 발생시킨다.")
    void shouldThrowExceptionForNonNumericMoveCount() {
        // Given
        String input = "abc";
        InputView inputView = new InputView();

        // When & Then
        assertInvalidMoveCountThrowsException(inputView, input);
    }

    private void assertInvalidMoveCountThrowsException(InputView inputView, String input) {
        assertThatThrownBy(() -> inputView.convertToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자여야 합니다.");
    }
}