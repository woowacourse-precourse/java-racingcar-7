package racingcar.io;

import java.util.List;

import static racingcar.constant.ErrorMessage.*;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validatePositive(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("입력값은 양수여야 합니다.");
        }
    }

    public void validateCarNames(List<String> carNames){

        validateDuplicates(carNames);

        for(String name : carNames) {
            validateCarNameLength(name);
            validateNotEmptyName(name);
        }
    }

    public void validateDuplicates(List<String> carNames) {
        if(isDuplicated(carNames)) {
            throwError(ERROR_DUPLICATED_CAR_NAME);
        }
    }

    private boolean isDuplicated(List<String> list) {
        return list.size() != list.stream().distinct().count();
    }

    public void validateCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH){
            throwError(ERROR_CAR_NAME_LENGTH);
        }
    }

    public void validateNotEmptyName(String name) {
        if(name == null || name.isBlank()){
            throwError(ERROR_EMPTY_CAR_NAME);
        }
    }

    private void throwError(String message) {
        throw new IllegalArgumentException(ERROR_HEAD + message);
    }
}
