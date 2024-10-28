package racingcar.receiver;

import racingcar.message.CarRaceMessage;

public interface InputReceiver<T> {
    T receiveWithMessage(CarRaceMessage message);

    default void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 공백으로만 입력할 수 없습니다.");
        }
    }
}
