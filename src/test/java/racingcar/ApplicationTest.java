package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    @MethodSource("provideNumberRandomSet")
    void 기능_테스트_MethodSource(int num1, int num2, int num3) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("gene7, pobi,woni", "1");
                    assertThat(output()).contains("gene7 : -", "pobi : -", "woni : ", "최종 우승자 : gene7, pobi");
                },
                num1, num2, num3
        );
    }

    public static Stream<Arguments> provideNumberRandomSet() {
        return Stream.of(
                Arguments.of(4, 5, 0),
                Arguments.of(9, 6, 2)
        );
    }


    @ParameterizedTest
    @CsvSource({"young,5", "ju,4", "J2085,9"})
    void 기능_테스트_CsvSource(String nameCars, int value) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(nameCars + ", pobi,woni", "1");
                    assertThat(output()).contains(nameCars + " : -", "pobi : -", "woni : ", "최종 우승자 : " + nameCars + ", pobi");
                },
                MOVING_FORWARD, value, STOP
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {8})
    void 기능_테스트_ValueSource(int randomNum) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
                },
                STOP, randomNum
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
}
