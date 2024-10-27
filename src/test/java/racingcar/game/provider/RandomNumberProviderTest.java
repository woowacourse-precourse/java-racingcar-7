package racingcar.game.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberProviderTest {
    private final RandomNumberProvider randomNumberProvider = new RandomNumberProvider();

    @Test
    @DisplayName("1부터 10 사이의 랜덤 숫자 반환")
    public void testGetNumberReturnsValidNumber() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = randomNumberProvider.getNumber();
            assertEquals(true, randomNumber >= 0 && randomNumber <= 9);
        }
    }
}