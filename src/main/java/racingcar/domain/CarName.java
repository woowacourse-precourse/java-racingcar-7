package racingcar.domain;

import java.util.List;
import static racingcar.message.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.message.ErrorMessage.INVALID_DUPLICATE_NAME;

public class CarName {
    private static final int MAX_LENGTH = 5;
    public static void validateCarName(List<String> carNames){
        validateCarNameLength(carNames);
        validateDuplicateName(carNames);
    }
    private static void validateDuplicateName(List<String> carNames){
        int distinctNameSize = carNames.stream().distinct().toList().size();
        if(carNames.size() != distinctNameSize){
            throw new IllegalArgumentException(INVALID_DUPLICATE_NAME.getMessage());
        }

    }
    private static void validateCarNameLength(List<String> carNames){
        for(String name:carNames){
            if(name.length() > MAX_LENGTH){
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }
}
