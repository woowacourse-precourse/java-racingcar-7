package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.race;
import static racingcar.MovingUnit.MOVING_FORWARD;
import static racingcar.MovingUnit.STOP;

class ApplicationTest extends NsTest {
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
    void 공동_우승자_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void 네번이동_기능_테스트(String players, String raceTime, String[] expectedContains, List<Integer> moves) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(players, raceTime);
                    assertThat(output()).contains(expectedContains);
                },
                moves.get(0), moves.get(1), moves.get(2),
                moves.get(3), moves.get(4), moves.get(5),
                moves.get(6), moves.get(7), moves.get(8),
                moves.get(9), moves.get(10), moves.get(11)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_횟수_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_경주게임_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            String carName = "pobi,woni";
            CarNames carNames = new CarNames(carName);
            Cars cars = new Cars(carNames.createCars());
            int raceTime = 3;

            race(raceTime, cars);

            assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : -", "pobi : ---", "woni : -");
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "pobi,woni,jun", "4",
                        new String[]{"pobi : -", "woni : ----", "jun : --", "최종 우승자 : woni"},
                        List.of(MOVING_FORWARD, MOVING_FORWARD, STOP,
                                STOP, MOVING_FORWARD, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, STOP)
                ),
                Arguments.of(
                        "pobi,woni,jun", "4",
                        new String[]{"pobi : --", "woni : ----", "jun : ----", "최종 우승자 : woni, jun"},
                        List.of(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, MOVING_FORWARD)
                ),
                Arguments.of(
                        "pobi,woni,jun", "4",
                        new String[]{"pobi : ---", "woni : ---", "jun : --", "최종 우승자 : pobi, woni"},
                        List.of(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, STOP,
                                STOP, STOP, STOP)
                ),
                Arguments.of(
                        "pobi,woni,jun", "4",
                        new String[]{"pobi : ----", "woni : ----", "jun : ---", "최종 우승자 : pobi, woni"},
                        List.of(MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD)
                )
        );
    }
}
