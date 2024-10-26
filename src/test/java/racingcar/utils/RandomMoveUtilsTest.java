package racingcar.utils;

import org.assertj.core.api.IntegerAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.utils.RandomMoveUtils.createRandomNumber;
import static racingcar.utils.RandomMoveUtils.isMoving;

public class RandomMoveUtilsTest {
    @DisplayName("무작위 정수가 범위 내에서 잘 생성되는지 확인")
    @Test
    public void randomNumberTest() {
        // given, when
        int randomNumber = createRandomNumber();

        //then
        new IntegerAssert(randomNumber).isBetween(0, 4);
    }

    @DisplayName("무작위 정수가 4 이상인 경우 정상적으로 true를 반환하는지 확인")
    @Test
    public void movingTest() {
        // given
        int randomNumber = 4;

        // when
        boolean moving = isMoving(randomNumber);
        boolean expectedMoving = true;

        //then
        Assertions.assertSame(moving, expectedMoving);
    }

    @DisplayName("무작위 정수가 4 이상인 경우 정상적으로 true를 반환하는지 확인")
    @Test
    public void stopTest() {
        // given
        int randomNumber = 0;

        // when
        boolean moving = isMoving(randomNumber);
        boolean expectedMoving = false;

        //then
        Assertions.assertSame(moving, expectedMoving);
    }
}
