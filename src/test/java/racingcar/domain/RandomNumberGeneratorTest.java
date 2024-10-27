package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @RepeatedTest(100)
    @DisplayName("테스트를 100번 실행해서 0이상 9이하의 숫자가 생성되는지 확인한다.")
    void generate() {
        int number = randomNumberGenerator.generate();
        assertThat(number).isBetween(0, 9);
    }
}
