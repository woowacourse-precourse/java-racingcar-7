package racingcar.service.input;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import racingcar.service.constant.ExpressionFormat;

public class Validation {

    // 공용 빈 입력 검증
    private static void vacantInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
