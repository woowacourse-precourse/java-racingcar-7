package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 무작위_값_생성_확인() {
        int randomValue = RandomNumberGenerator.pickNumberInRange(0, 9);
        assertTrue(randomValue >= 0 && randomValue <= 9, "0에서 9사이의 무작위 값을 반환해야 합니다.");
    }
}
