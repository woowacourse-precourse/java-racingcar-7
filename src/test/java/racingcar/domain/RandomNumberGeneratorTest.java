package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {

    @DisplayName("Randoms.pickNumberInRange()는 0에서 9 사이의 값을 고르게 생성하는지 검증")
    @RepeatedTest(100)
    void generateRandomNumberWithinRange() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        assertThat(randomValue).isBetween(0, 9);
    }
}
