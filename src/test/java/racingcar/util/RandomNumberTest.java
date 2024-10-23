package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @DisplayName("생성된 랜덤숫자가 0과 9 사이인지 테스트")
    @Test
    public void randomNumberRangeTest() {
        int randomNumber = RandomNumber.generateRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}
