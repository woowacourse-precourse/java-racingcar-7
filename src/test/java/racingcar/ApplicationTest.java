package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @ParameterizedTest
    @CsvSource({
            "'pobi', '2', 'pobi : -', 'pobi : -', '최종 우승자 : pobi', 5, 2",
            "'pobi, woni', '1', 'pobi : ', 'woni : -', '최종 우승자 : woni', 3, 6",
            "'pobi, woni', '1', 'pobi : -', 'woni : -', '최종 우승자 : pobi, woni', 5, 6",
            "'pobi,woni,', '1', 'pobi : -', 'woni : ', '최종 우승자 : pobi', 4, 2",
            "'pobi,woni', '0', '', '', '최종 우승자 : pobi, woni', 3, 6"
    })
    void 나의_기능_테스트(String name, String attempt, String expectedOutput1, String expectedOutput2,
                   String expectedWinner, int moveOrStop1, int moveOrStop2) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(name, attempt);
                    assertThat(output()).contains(expectedOutput1, expectedOutput2, expectedWinner);
                },
                moveOrStop1, moveOrStop2
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'', '1'",
            "'pobi,wonijun', '1'",
            "',javaji', '1'",
            "'pobi,woni', '-3'",
            "'pobi,woni', 'n'"
    })
    void 나의_예외_테스트(String players, String attempts) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(players, attempts))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
