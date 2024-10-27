package racingcar.model;

import static racingcar.message.ExceptionMessage.INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.GameSettings;

public class RacingGame {

    private final List<RacingRecord> records = new ArrayList<>();

    public RacingGame(String names) {
        List<Car> cars = CarsGenerator.generateFrom(names);
        for (Car car : cars) {
            records.add(new RacingRecord(car));
        }
    }

    public List<RacingRecord> getRecords() {
        return records;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(GameSettings.MIN_RANDOM_NUMBER.getNumber()
                , GameSettings.MAX_RANDOM_NUMBER.getNumber());
    }

    public void racing(List<Integer> randomNumbersOfRound) {
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
