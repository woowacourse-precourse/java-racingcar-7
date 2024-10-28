package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.GameSettings;

public class Generator {
    public List<Car> generateCarsFrom(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(GameSettings.MIN_RANDOM_NUMBER.getNumber()
                , GameSettings.MAX_RANDOM_NUMBER.getNumber());
    }

    public List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(generateRandomNumber());
        }
        return randomNumbers;
    }

    public List<RacingRecord> generateRecordsFrom(String names) {
        List<RacingRecord> records = new ArrayList<>();

        List<Car> cars = generateCarsFrom(names);
        for (Car car : cars) {
            records.add(new RacingRecord(car));
        }
        return records;
    }
}
