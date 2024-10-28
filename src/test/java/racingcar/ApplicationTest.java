package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    List<Integer> numbers = Arrays.asList(3, 4);
    List<Integer> numbers2 = Arrays.asList(4, 5);
    List<Integer> numbers3 = Arrays.asList(5, 6);
    List<Integer> numbers4 = Arrays.asList(0, 5);

    List<Integer> numbers5 = Arrays.asList(3, 4, 7);
    List<Integer> numbers6 = Arrays.asList(4, 5, 5);
    List<Integer> numbers7 = Arrays.asList(5, 6, 8);
    List<Integer> numbers8 = Arrays.asList(0, 5, 8);


    @BeforeEach
    void setUp() {
        Application.participantList.clear();
        Application.participantScore.clear();
        Application.winners.clear();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : --", "woni : ----", "최종 우승자 : woni");
                },
                numbers, numbers2, numbers3, numbers4
        );
    }

    @Test
    void 기능_테스트4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("pobi,woni,abcd", "4");
                    assertThat(output()).contains("pobi : --", "woni : ----", "abcd : ----", "최종 우승자 : woni, abcd");
                },
                numbers5, numbers6, numbers7, numbers8
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi2,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void blankExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",a", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void wrongNumExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Tom,Amy,Devil", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
