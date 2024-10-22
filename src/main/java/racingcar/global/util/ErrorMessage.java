package racingcar.global.util;

import static racingcar.global.util.CarConst.*;

public enum ErrorMessage {
    INVALID_NAME_FORMAT("[ERROR] 이름은 영문, 숫자, 한글 8글자만 입력해주세요"),
    INVALID_CARS_RANGE(String.format("[ERROR] 자동차는 %d~%d개 사이만 입력하실 수 있습니다.", MIN_CARS_RANGE, MAX_CARS_RANGE)),

    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    String message;

    public String getMessage() {
        return message;
    }
}
