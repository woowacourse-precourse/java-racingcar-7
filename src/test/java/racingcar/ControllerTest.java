package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ControllerTest extends NsTest {
    @Test
    void 기능_단독_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,abcd", "3");
                    assertThat(output()).contains("pobi : -", "woni : --", "abcd : ---", "최종 우승자 : abcd");
                },
                1, 5, 7, 3, 3, 4, 6, 9, 10
        );
    }

    @Test
    void 기능_공동_우승1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,abcd", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ---", "abcd : ---", "최종 우승자 : pobi, woni, abcd");
                },
                5, 5, 5, 5, 5, 5, 5, 5, 5
        );
    }

    @Test
    void 기능_공동_우승2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,abcd", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "abcd : ---", "최종 우승자 : pobi, abcd");
                },
                5, 3, 5, 5, 3, 5, 5, 3, 5
        );
    }

    @Test
    void 기능_공동_우승3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,abcd", "3");
                    assertThat(output()).contains("pobi : ", "woni : ---", "abcd : ---", "최종 우승자 : woni, abcd");
                },
                3, 5, 5, 3, 5, 5, 3, 5, 5
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
