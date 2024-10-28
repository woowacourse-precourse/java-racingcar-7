package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0에서 9사이 생성 테스트")
    void numberInZeroToNineTest() {
        int randomNumber = RandomNumberGenerator.generateSingleNumberBetweenZeroAndNine();
        assertThat(randomNumber).isBetween(0, 9);
    }
}