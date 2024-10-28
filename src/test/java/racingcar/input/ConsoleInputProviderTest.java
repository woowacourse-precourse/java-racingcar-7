package racingcar.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.CarRaceMessage;
import racingcar.receiver.CarNameInputReceiver;
import racingcar.receiver.InputReceiver;

import static org.assertj.core.api.Assertions.*;

class ConsoleInputProviderTest {

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
        String input = "pobi,woni,jun";
        InputProvider inputProvider = new StubInputProvider(input);

        // When
        String result = inputProvider.readInput(CarRaceMessage.REQUEST_CAR_NAME.getMessage());

        // Then
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("예외 - 빈 입력")
    void fail_BlankInput() {
        // Given
        String input = "   ";
        InputProvider inputProvider = new StubInputProvider(input);

        // When & Then
        assertThatThrownBy(() -> {
            InputReceiver<String> receiver = new CarNameInputReceiver(inputProvider);
            receiver.receiveWithMessage(CarRaceMessage.REQUEST_CAR_NAME);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 공백으로만 입력할 수 없습니다.");
    }
}