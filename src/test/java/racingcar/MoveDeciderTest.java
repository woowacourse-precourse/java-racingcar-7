package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class MoveDeciderTest extends NsTest {

    @Test
    void pickRandomNum() {
        int randomNum = MoveDecider.pickRandomNum();
        assertThat(randomNum).isBetween(0, 9);

    }

    @Test
    void isMovable() {
        int randomNum = MoveDecider.pickRandomNum();
        String moved = MoveDecider.isMovable(randomNum);

        if (randomNum > 3) {
            assertThat(moved).isEqualTo("-");
        } else {
            assertThat(moved).isEqualTo("");
        }
    }

    @Test
    void move() {
        run("Harry,Amy,Tom");
        String result = MoveDecider.move();
        assertThat(result).contains("Harry : ","Amy : ","Tom : ");

    }


    @Override
    protected void runMain() {

    }
}