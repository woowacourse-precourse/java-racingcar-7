package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber {

    public static List<Integer> createRandomNumber(Integer count){
        return IntStream.range(0,count)
                .mapToObj(i -> Randoms.pickNumberInRange(0, 9))
                .collect(Collectors.toList());
    }
}
