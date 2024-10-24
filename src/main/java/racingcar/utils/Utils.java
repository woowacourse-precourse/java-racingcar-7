package racingcar.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Validation;

public class Utils {

    private static final String DELIMITER = ",";
    public static List<String> stringToList(String input){
        return Arrays.stream(splitStringToArray(input)).toList();
    }

    private static String[] splitStringToArray(String input){
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public static int stringToInt(String input){
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }

    public static int getMaxValue(List<Integer> numbers){
        return Collections.max(numbers);
    }

}
