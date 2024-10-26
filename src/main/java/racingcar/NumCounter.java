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
}
