package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberGenerator {
    public static List<Integer> generateRandomNumbersForSize(int size){
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(0, size)
                .forEach(i -> randomNumbers.add(pickNumberInRange(0,9)));
        return randomNumbers;
    }
}
