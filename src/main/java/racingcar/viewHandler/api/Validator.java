package racingcar.viewHandler.api;

import racingcar.viewHandler.api.message.ExceptionMessageImpl;

import java.util.List;

import static racingcar.viewHandler.api.message.ErrorMessage.라운드_숫자_입력_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.라운드_양수_입력_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.차_이름_크기_에러;
import static racingcar.viewHandler.api.message.ErrorMessage.차_입력_에러;

public class Validator {
    private final Integer MIN_CAR_COUNT_SIZE = 2;
    private final Integer MAX_CAR_NAME_SIZE = 5;

    public Validator() {
    }

    public void validateMinCarCount(List<String> carnames) {
        if(carnames.size() < MIN_CAR_COUNT_SIZE) {
            throw new ExceptionMessageImpl(차_입력_에러);
        }
    }

    public void validateCarNameLength(List<String> carnames) {
        if(carnames.stream().anyMatch(carname -> carname.length() > MAX_CAR_NAME_SIZE)){
            throw new ExceptionMessageImpl(차_이름_크기_에러);
        }
    }

    public Integer tryParserToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new ExceptionMessageImpl(라운드_숫자_입력_에러);
        }
    }

    public void validatePositiveNumber(Integer number) {
        if(number <= 0) {
            throw new ExceptionMessageImpl(라운드_양수_입력_에러);
        }
    }
}
