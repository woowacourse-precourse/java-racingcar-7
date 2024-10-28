package racingcar.receiver;

import racingcar.input.InputProvider;
import racingcar.message.CarRaceMessage;

public class RoundInputReceiver implements InputReceiver<Integer> {

    private final InputProvider inputProvider;
    private final int maximumRound;

    public RoundInputReceiver(InputProvider inputProvider, int maximumRound) {
        this.inputProvider = inputProvider;
        this.maximumRound = maximumRound;
    }

    @Override
    public Integer receiveWithMessage(CarRaceMessage message) {
        String input = inputProvider.readInput(message.getMessage());
        validateBlank(input);
        validateNumber(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(maximumRound +"까지 가능합니다.");
        }
    }

    private void validateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }
}
