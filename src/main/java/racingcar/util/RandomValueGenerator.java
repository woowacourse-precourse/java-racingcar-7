package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomValueGenerator {

    public int generateSingle(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    public List<Integer> generateMultiple(int startInclusive, int endInclusive, int count) {
        List<Integer> randomValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomValues.add(generateSingle(startInclusive, endInclusive));
        }
        return randomValues;
    }
}