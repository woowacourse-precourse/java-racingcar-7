package racingcar.util;

import racingcar.exception.ErrorMessage;
import racingcar.exception.ExceptionHandler;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringUtil {
    private StringUtil(){};
    public static Collection<String> splitNames(String carNames, String delimiter){
        return Arrays.stream(carNames.split(delimiter)).map(String::strip).collect(Collectors.toList());
    }

    public static int parsePositiveNumber(String number){
        try {
            int parsedNumber = Integer.parseInt(number);
            if(parsedNumber<=0){
                ExceptionHandler.handleIllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
            }
            return parsedNumber;
        }catch (RuntimeException e){
            ExceptionHandler.handleIllegalArgumentException(ErrorMessage.INTEGER_TYPE_ERROR);
            return 0;
        }
    }
}
