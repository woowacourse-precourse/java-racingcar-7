package racingcar.receiver;

import racingcar.input.InputProvider;
import racingcar.message.CarRaceMessage;

public class CarNameInputReceiver implements InputReceiver<String> {

    private final InputProvider inputProvider;

    public CarNameInputReceiver(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public String receiveWithMessage(CarRaceMessage message) {
        if (message != null) {
            String input = inputProvider.readInput(message.getMessage());
            validateBlank(input);
            return input;
        }
        String input = inputProvider.readInput(null);
        validateBlank(input);
        return input;
    }
}
