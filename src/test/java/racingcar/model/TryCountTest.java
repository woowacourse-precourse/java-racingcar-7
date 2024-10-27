package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.TryCount;
import racingcar.validator.TryCountValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TryCountTest {
    @DisplayName("시도 횟수가 0이 아니라면 true를 반환한다.")
    @Test
    void checkTryCountNotZero(){
        //Arrange
        TryCount tryCount = new TryCount(1, new TryCountValidator());

        //Act
        boolean result = tryCount.isNotZero();

        //Assert
        assertEquals(true, result);
    }

    @DisplayName("시도 횟수가 0이면 false를 반환한다.")
    @Test
    void checkTryCountZero(){
        //Arrange
        TryCount tryCount = new TryCount(0, new TryCountValidator());

        //Act
        boolean result = tryCount.isNotZero();

        //Assert
        assertEquals(false, result);
    }
}
