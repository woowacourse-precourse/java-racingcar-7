package racingcar;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void generateRandomNumber_범위_테스트() {
        int randomValue = RandomNumberGenerator.generateRandomNumber();
        assertThat(randomValue).isBetween(0, 9);
    }
}
