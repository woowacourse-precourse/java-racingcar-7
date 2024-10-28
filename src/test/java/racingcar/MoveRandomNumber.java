package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumber;

public class MoveRandomNumber implements RandomNumber {

    @Override
    public List<Integer> createNumbers(Integer count) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(Randoms.pickNumberInRange(4, 9));
        }
        return numbers;
    }
}
