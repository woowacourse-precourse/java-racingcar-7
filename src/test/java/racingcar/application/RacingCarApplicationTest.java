package racingcar.application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Application;

class RacingCarApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("잘못된 형식 예외")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("inputs")
    void exceptionTest(String cars,String round){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(cars,round))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("","3"),
                Arguments.of("car1, ,car2","3"),
                Arguments.of("car1,car1","3"),
                Arguments.of("car1,,car2","3"),
                Arguments.of("!!!,car2","3"),
                Arguments.of("longName,car2","3"),
                Arguments.of("car1,car2","0"),
                Arguments.of("car1,car2","three")
        );
    }

    @DisplayName("단독 우승자 선정")
    @Test
    void soloWinnerTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("우아,테코", "3");
                    assertThat(output()).contains("최종 우승자 : 우아");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }
    @DisplayName("공동 우승자 선정")
    @Test
    void jointWinnerTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("우아,테코", "3");
                    assertThat(output()).contains("최종 우승자 : 우아, 테코");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}