package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGameRandomNumber implements RandomNumber {

    @Override
    public List<Integer> createNumbers(Integer count) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return numbers;
    }
}
