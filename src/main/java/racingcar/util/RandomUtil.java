package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomUtil {
    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 9;

    public static List<Integer> generateRandomNumberForCars(int carSize) {
        return IntStream.range(0, carSize)
                .map(i -> pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX))
                .boxed()
                .collect(Collectors.toList());
    }
}
