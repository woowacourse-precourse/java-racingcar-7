package racingcar.model;

import static racingcar.message.ExceptionMessage.INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE;

import java.util.List;
import racingcar.GameSettings;

public class RacingGame {

    public void racing(List<Integer> randomNumbersOfRound, List<RacingRecord> records) {
        checkingRandomNumbers(randomNumbersOfRound);

        for (int i = 0; i < randomNumbersOfRound.size(); i++) {
            RacingRecord record = records.get(i);
            record.recordMovement(randomNumbersOfRound.get(i));
        }
    }

    private void checkingRandomNumbers(List<Integer> randomNumbersOfRound) {
        for (int randomNumber : randomNumbersOfRound) {
            if (isValidRandomNumber(randomNumber)) {
                throw new IllegalArgumentException(INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE.getMessage());
            }
        }
    }

    private boolean isValidRandomNumber(int randomNumber) {
        return ((randomNumber > GameSettings.MAX_RANDOM_NUMBER.getNumber())
                | (randomNumber < GameSettings.MIN_RANDOM_NUMBER.getNumber()));
    }
}
