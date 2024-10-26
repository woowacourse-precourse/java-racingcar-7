package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static racingcar.message.ErrorMessage.INVALID_CAR_NAME_LENGTH;

public class SplitName {
    private static final String DELIMITER_COMMA = ",";
    public static List<String> splitCarName(final String input){
        List<String> carNameList = Arrays.stream(input.split(DELIMITER_COMMA, -1)).map(String::trim).collect(Collectors.toList());
        validateCarName(carNameList);
        return carNameList;
    }
    private static void validateCarName(List<String> carNameList){
        for(String carName: carNameList){
            if(carName.isEmpty()){
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }
}

