package racingcar;

import racingcar.common.exception.GlobalException;
import racingcar.common.exception.dto.ExceptionEnum;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        throw new GlobalException(ExceptionEnum.RUTIME_ERROR);
    }
}
