package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.RandomNumbers;

public class RandomNumbersGenerator {
    public RandomNumbers generate(int carCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return RandomNumbers.create(randomNumbers);
    }
}
