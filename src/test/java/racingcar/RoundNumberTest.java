package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundNumberTest {

    @Test
    void testValidRoundNumberCreation() {

        assertThatCode(() -> new RoundNumber(1)).doesNotThrowAnyException();
    }

    @Test
    void testInvalidRoundNumberCreation() {

        assertThatThrownBy(() -> new RoundNumber(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RoundNumber(0.1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RoundNumber('a'))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
