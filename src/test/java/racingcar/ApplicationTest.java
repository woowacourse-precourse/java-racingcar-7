package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    @DisplayName("전체 로직이 잘 작동하는지 확인한다")
    void basicApplicationTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hb", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hb : ", "최종 우승자 : pobi, woni, hb");
                },
                1, 1, 1
        );
    }


    @ParameterizedTest
    @DisplayName("발생되어야 하는 예외가 정상적으로 발생되는지 확인한다")
    @MethodSource("provideArgumentsForExceptionTest")
    void exceptionTest(String carNameString, String racingAttemptCountString) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNameString, racingAttemptCountString))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    static Stream<Arguments> provideArgumentsForExceptionTest() {
        return Stream.of(
                Arguments.of("pobi,javaji", "1"),
                Arguments.of("po  bi,java", "1"),
                Arguments.of("pobi,java", "0"),
                Arguments.of("pobi,java", "-1"),
                Arguments.of("pobi,java", "1.1"),
                Arguments.of("", "1")
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
