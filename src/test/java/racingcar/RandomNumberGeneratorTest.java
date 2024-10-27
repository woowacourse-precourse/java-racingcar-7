package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;


class RandomNumberGeneratorTest {

    @Test
    @DisplayName("Generated number is within the expected range")
    void generatedNumberWithinRange() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generate();
        assertThat(number).isBetween(0, 9);
    }

    @Test
    @DisplayName("Generated number is not negative")
    void generatedNumberIsNotNegative() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generate();
        assertThat(number).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("Generated number is less than 10")
    void generatedNumberIsLessThanTen() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generate();
        assertThat(number).isLessThan(10);
    }
}