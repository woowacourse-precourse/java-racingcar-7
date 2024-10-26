package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class NumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤_숫자_생성_테스트() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int min = 0;
        int max = 10;

        int randomValue = randomNumberGenerator.generateNumber();
        System.out.println("randomValue = " + randomValue);

        Assertions.assertThat(randomValue).isBetween(min, max);
    }
}
