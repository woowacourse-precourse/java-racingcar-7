package racingcar.validTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;
import racingcar.valid.NumberValid;

class NumberValidTest {
    @Test
    @DisplayName("숫자 형식 검증 테스트")
    void checkNumberTypeTest() {
        // 정상 케이스
        Assertions.assertDoesNotThrow(() ->
                NumberValid.checkNumberType("50")
        );

        // 숫자가 아닌 경우
        IllegalArgumentException notNumber = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NumberValid.checkNumberType("abc")
        );
        Assertions.assertEquals(ExceptionMessage.ATTEMPT_COUNT, notNumber.getMessage());


        // 음수
        IllegalArgumentException negative = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NumberValid.checkNumberType("-1")
        );
        Assertions.assertEquals(ExceptionMessage.ATTEMPT_COUNT, negative.getMessage());


        // 너무 큰 숫자
        IllegalArgumentException tooLarge = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NumberValid.checkNumberType("1234567890")
        );
        Assertions.assertEquals(ExceptionMessage.ATTEMPT_COUNT, tooLarge.getMessage());
    }

    @Test
    @DisplayName("숫자 범위 검증 테스트")
    void checkNumberRangeTest() {
        Assertions.assertDoesNotThrow(() ->
            NumberValid.checkNumber(50)
        );
        // 경계값 테스트
        Assertions.assertDoesNotThrow(() -> {
            NumberValid.checkNumber(1);
            NumberValid.checkNumber(100);
        });

        // 최소값 미만
        IllegalArgumentException under = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NumberValid.checkNumber(0)
        );
        Assertions.assertEquals(ExceptionMessage.ATTEMPT_COUNT_UNDER, under.getMessage());

        // 최대값 초과
        IllegalArgumentException over = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> NumberValid.checkNumber(101)
        );
        Assertions.assertEquals(ExceptionMessage.ATTEMPT_COUNT_OVER, over.getMessage());


    }
}