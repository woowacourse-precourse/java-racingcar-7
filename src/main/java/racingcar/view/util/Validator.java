package racingcar.view.util;

import java.util.List;

import static racingcar.view.util.ErrorMessage.라운드_숫자_입력_에러;
import static racingcar.view.util.ErrorMessage.라운드_양수_입력_에러;
import static racingcar.view.util.ErrorMessage.차_이름_크기_에러;
import static racingcar.view.util.ErrorMessage.차_입력_에러;

public class Validator {
    private final Integer MIN_CAR_COUNT_SIZE = 2;
    private final Integer MAX_CAR_NAME_SIZE = 5;

    public Validator() {
    }

    public void validateMinCarCount(List<String> carnames) {
        if(carnames.size() < MIN_CAR_COUNT_SIZE) {
            throw new IllegalArgumentException(차_입력_에러.getMessage());
        }
    }

    public void validateCarNameLength(List<String> carnames) {
        if(carnames.stream().anyMatch(carname -> carname.length() > MAX_CAR_NAME_SIZE)){
            throw new IllegalArgumentException(차_이름_크기_에러.getMessage());
        }
    }

    public Integer tryParserToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(라운드_숫자_입력_에러.getMessage());
        }
    }

    public void validatePositiveNumber(Integer number) {
        if(number <= 0) {
            throw new IllegalArgumentException(라운드_양수_입력_에러.getMessage());
        }
    }
}
