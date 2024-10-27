package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ModeTest {
    @Test
    void mode_무작위_수_생성() {
        RacingCar input = new RacingCar();
        Integer result = input.getRandomNumber();

        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(9);
    }
}
