package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class MoveDeciderTest {

    @Test
    void pickRandomNum() {
        int randomNum = MoveDecider.pickRandomNum();
        assertThat(randomNum).isBetween(0, 9);

    }

}