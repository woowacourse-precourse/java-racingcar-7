package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<RandomNumber> randomNumbers;

    public RandomNumbers(Integer count) {
        this.randomNumbers = new ArrayList<>();

        for (int i = 0; i < count; i ++) {
            addRandomNumber();
        }
    }

    public RandomNumbers (List<RandomNumber> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }


    private void addRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        this.randomNumbers.add(randomNumber);
    }

    public boolean isMove(int index) {
        RandomNumber randomNumber = randomNumbers.get(index);
        return randomNumber.isMove();
    }

    public int size() {
        return randomNumbers.size();
    }
}
