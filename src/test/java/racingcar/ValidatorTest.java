package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력에서")
public class ValidatorTest {

    @Test
    @DisplayName("자동차 수가 2개 미만이면 IllegalArgumentException이 발생한다.")
    public void racingCarAmountLessThan2() {
        Assertions.assertFalse(UserInputValidator.isLessThanTwo(new String[]{"name"}));
    }

    @Test
    @DisplayName("자동차 이름이 5 이상이면 IllegalArgumentException이 발생한다.")
    public void racingCarNameLengthMoreThan5() {
        Assertions.assertFalse(UserInputValidator.isValidRacingCarName(new String[]{"namesadf", "dksn"}));
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 IllegalArgumentException이 발생한다.")
    public void tryCountNotNumber() {
        Assertions.assertFalse(UserInputValidator.isNumberTryCount("504d"));
    }

    @Test
    @DisplayName("시도 횟수가 long의 범위보다 크면 IllegalArgumentException이 발생한다.")
    public void tryCountTooBingNumber() {
        Assertions.assertFalse(UserInputValidator.isNotTooBigTryCount(
                "190980989087897978979798789879789879078987978979878978987979087890"));
    }

    @Test
    @DisplayName("시도 횟수가 0보다 작거나 같으면 IllegalArgumentException이 발생한다.")
    public void tryCountTooSmall() {
        Assertions.assertFalse(UserInputValidator.isPositiveTryCount(
                "-5"));
    }
}
