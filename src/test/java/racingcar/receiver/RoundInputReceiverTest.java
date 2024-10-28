package racingcar.receiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.InputProvider;
import racingcar.message.CarRaceMessage;

import static org.assertj.core.api.Assertions.*;

class RoundInputReceiverTest {

    static class StubInputProvider implements InputProvider {
        private final String input;

        public StubInputProvider(String input) {
            this.input = input;
        }

        @Override
        public String readInput(String includeMessage) {
            return input;
        }
    }

    @Test
    @DisplayName("정상 입력")
    void success_ValidInput() {
        // Given
        String input = "5";
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<Integer> receiver = new RoundInputReceiver(inputProvider, 10000);

        // When
        Integer round = receiver.receiveWithMessage(CarRaceMessage.REQUEST_LAPS);

        // Then
        assertThat(round).isEqualTo(5);
    }

    @Test
    @DisplayName("예외 - 빈 입력")
    void fail_BlankInput() {
        // Given
        String input = "   ";
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<Integer> receiver = new RoundInputReceiver(inputProvider, 10000);

        // When & Then
        assertThatThrownBy(() -> receiver.receiveWithMessage(CarRaceMessage.REQUEST_LAPS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 공백으로만 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("예외 - 숫자가 아닌 입력")
    void fail_NonNumericInput() {
        // Given
        String input = "abc";
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<Integer> receiver = new RoundInputReceiver(inputProvider, 10000);

        // When & Then
        assertThatThrownBy(() -> receiver.receiveWithMessage(CarRaceMessage.REQUEST_LAPS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("예외 - 최대 라운드 초과 입력")
    void fail_IntegerParseFailure() {
        // Given
        String input = "999999999999999999999999999"; // Overflow
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<Integer> receiver = new RoundInputReceiver(inputProvider, 10000);

        // When & Then
        assertThatThrownBy(() -> receiver.receiveWithMessage(CarRaceMessage.REQUEST_LAPS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(10000 + "까지 가능합니다.");
    }
}