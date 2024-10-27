package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BasicRacingCarGameRandomGenerator implements RacingCarGameRandomGenerator {
    @Override
    public List<Integer> generateRandomNumbers(int racingCarCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < racingCarCount; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumbers;
    }
}
