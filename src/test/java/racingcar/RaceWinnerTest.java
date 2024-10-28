package racingcar;

import static org.assertj.core.api.Assertions.assertThat;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RaceWinnerTest extends NsTest {

    @Test
    void findWinner() {
        run("Harry,Amy,Tom", "3");
        String result = RaceWinner.findWinner();
        assertThat(result).contains("최종 우승자: ");
    }

    @Override
    protected void runMain() {

    }
}