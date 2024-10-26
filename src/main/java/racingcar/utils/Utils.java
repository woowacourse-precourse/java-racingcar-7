package racingcar.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Validation;

public class Utils {
    private static final String DELIMITER = ",";

    private static int MIN_RANDOM_VALUE = 0;
    private static int MAX_RANDOM_VALUE = 9;

    public static List<String> stringToList(String input){
        return Arrays.stream(splitStringToArray(input)).toList();
    }

    private static String[] splitStringToArray(String input){
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    public static int stringToInt(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static int getMaxValue(List<Integer> numbers){
        return Collections.max(numbers);
    }

    public static String repeatString(String target, int count){
        return target.repeat(count);
    }

    public static <T> Set<T> listToSet(List<T> list){
        return list.stream().collect(Collectors.toSet());
    }

}
