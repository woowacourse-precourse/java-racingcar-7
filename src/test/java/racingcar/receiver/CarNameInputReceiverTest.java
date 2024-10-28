package racingcar.receiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.InputProvider;
import racingcar.message.CarRaceMessage;

import static org.assertj.core.api.Assertions.*;

class CarNameInputReceiverTest {

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
    @DisplayName("정상 입력 수신")
    void success_ReceiveValidInput() {
        // Given
        String input = "pobi,woni,jun";
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<String> receiver = new CarNameInputReceiver(inputProvider);

        // When
        String result = receiver.receiveWithMessage(CarRaceMessage.REQUEST_CAR_NAME);

        // Then
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("예외 - 빈 입력")
    void fail_BlankInput() {
        // Given
        String input = "   ";
        InputProvider inputProvider = new StubInputProvider(input);
        InputReceiver<String> receiver = new CarNameInputReceiver(inputProvider);

        // When & Then
        assertThatThrownBy(() -> receiver.receiveWithMessage(CarRaceMessage.REQUEST_CAR_NAME))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 공백으로만 입력할 수 없습니다.");
    }
}