package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public static Integer RANDOM_NUMBER_START_RANGE = 0;
    public static Integer RANDOM_NUMBER_END_RANGE = 9;

    public static List<Integer> generateRandomNumbersForSize(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(0, size)
                .forEach(i -> randomNumbers.add(pickNumberInRange(RANDOM_NUMBER_START_RANGE, RANDOM_NUMBER_END_RANGE)));
        return randomNumbers;
    }
}
