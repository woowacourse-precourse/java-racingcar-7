package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Map;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("모두 승자")
    void testSimulateFullRace_AllWins() {
        // given
        String[] names = {"pobi", "java"};
        int tryCount = 2;
        Supplier<Integer> alwaysWinSupplier = () -> 4;

        // when
        Map<String, boolean[]> result = Application.simulateFullRace(names, tryCount,
                alwaysWinSupplier);

        // then
        for (boolean[] gameWinHistory : result.values()) {
            for (boolean win : gameWinHistory) {
                Assertions.assertThat(win).isTrue();
            }
        }
    }

}
