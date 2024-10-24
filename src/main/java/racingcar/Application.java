package racingcar;

import racingcar.common.exception.GlobalException;
import racingcar.common.exception.dto.ExceptionEnum;
import racingcar.view.exception.InputException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        throw new InputException(ExceptionEnum.INVALID_INPUT);
    }
}
