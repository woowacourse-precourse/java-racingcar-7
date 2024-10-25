package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarTest {
    @Test
    void testMoveRacingcar() {
        Racingcar racingcar = new Racingcar("jun");

        Racingcar.moveRacingcar(racingcar);

        assertThat(racingcar.getMoveCount()).isEqualTo(1);
    }
}
