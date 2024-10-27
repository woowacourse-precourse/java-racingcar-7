package racingcar.domain.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarStateNumberTest {

    @Test
    void 고정된_숫자를_반환한다() {
        // given
        RandomNumberGenerator random = new CarStateNumber();
        int expected = 4;

        // when
        int actual = random.generateRandomNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
