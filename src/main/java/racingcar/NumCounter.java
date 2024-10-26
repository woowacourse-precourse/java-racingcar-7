package racingcar;

import java.util.List;

public class NumCounter {

    public int countCars(List<String> carNames) {
        int carCount = carNames.size();
        return carCount;
    }

    public void validateCarCount(int carCount) {
        if(carCount <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarNames(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            validateCarName(carName);
        }
    }

    public void validateCarName(String carName) {
        int carNameLength = carName.length();
        if(carNameLength <= 0 || carNameLength > 5) {
            throw new IllegalArgumentException();
        }
    }
}
