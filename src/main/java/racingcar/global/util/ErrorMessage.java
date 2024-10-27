package racingcar.global.util;

import static racingcar.global.util.CarConst.MAX_CARS_RANGE;
import static racingcar.global.util.CarConst.MAX_TRY_COUNT_RANGE;
import static racingcar.global.util.CarConst.MIN_CARS_RANGE;
import static racingcar.global.util.CarConst.MIN_TRY_COUNT_RANGE;

public enum ErrorMessage {
    INVALID_NAME_FORMAT("[ERROR] 이름은 영문, 숫자, 한글 8글자만 입력해주세요"),
    INVALID_CARS_RANGE(String.format("[ERROR] 자동차는 %d~%d개 사이만 입력하실 수 있습니다.", MIN_CARS_RANGE, MAX_CARS_RANGE)),
    INVALID_TRY_COUNT(String.format("[ERROR] 시도할 숫자는 2~9사이 숫자만 입력해 주세요", MIN_TRY_COUNT_RANGE, MAX_TRY_COUNT_RANGE));

    ErrorMessage(String message) {
        this.message = message;
    }

    String message;

    public String getMessage() {
        return message;
    }
}
