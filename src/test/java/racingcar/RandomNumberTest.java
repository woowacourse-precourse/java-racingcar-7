package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    @DisplayName("랜덤 숫자가 0에서 9사이의 수인지 확인")
    void 랜덤_숫자는_0과_9사이인지_확인() {
        for (int i = 0; i < 100; i++) {
            int random = randomNumber.makeNumber();
            Assertions.assertEquals(random >= 0 && random <= 9, true);
        }
    }

}
