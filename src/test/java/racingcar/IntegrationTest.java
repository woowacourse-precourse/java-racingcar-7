package racingcar;

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

public class IntegrationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 이름 입력 기능")
    @Test
    void 자동차_이름_입력_기능() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("rc1,rc2,rc3", "1");
                    assertThat(output()).containsSubsequence(
                            "rc1 : -",
                            "rc2 : -",
                            "rc3 : -");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("전진 시도 횟수 입력 기능")
    @Test
    void 전진_시도_횟수_입력_기능() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("rc1,rc2", "3");
                    assertThat(output())
                            .containsSubsequence(
                                    "rc1 : -",
                                    "rc1 : --",
                                    "rc1 : ---");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("자동차 경주 진행 기능")
    @Test
    void 자동차_경주_진행_기능() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("rc1,rc2", "3");
                    assertThat(output())
                            .containsSubsequence(
                                    "rc1 : -",
                                    "rc2 : ",
                                    "rc1 : -",
                                    "rc2 : -",
                                    "rc1 : --",
                                    "rc2 : -",
                                    "최종 우승자 : rc1");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("자동차 경주 결과 출력 기능")
    @ParameterizedTest(name = "경주 결과 출력 : \"{2}\"")
    @MethodSource()
    void 자동차_경주_결과_출력_기능(int firstCarRandomNumber, int secondCarRandomNumber, String raceResult) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("rc1,rc2", "1");
                    assertThat(output())
                            .contains(raceResult);
                },
                firstCarRandomNumber, secondCarRandomNumber
        );
    }

    private static Stream<Arguments> 자동차_경주_결과_출력_기능() {
        return Stream.of(
                Arguments.of(MOVING_FORWARD, STOP, "최종 우승자 : rc1"),
                Arguments.of(MOVING_FORWARD, MOVING_FORWARD, "최종 우승자 : rc1,rc2")
        );
    }

    @DisplayName("자동차 경주 진행 상황 출력 기능")
    @Test()
    void 자동차_경주_진행_상황_출력_기능() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("rc1,rc2", "2");
                    assertThat(output())
                            .containsSubsequence(
                                    "실행 결과",
                                    "rc1 : -",
                                    "rc2 : -",
                                    "rc1 : -",
                                    "rc2 : --");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD
        );
    }

    @DisplayName("자동차 이름 입력에 대한 검증 기능")
    @ParameterizedTest(name = "\"{0}\" 입력 : 예외메세지 - \"{1}\"")
    @MethodSource()
    void 자동차_이름_입력에_대한_검증_기능(String carNameInput, String expectedExceptionMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNameInput, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(expectedExceptionMessage)
        );
    }

    private static Stream<Arguments> 자동차_이름_입력에_대한_검증_기능() {
        return Stream.of(
                Arguments.of("  ", "비어있는 값이 입력되었습니다."),
                Arguments.of("rc1", "자동차 1대의 이름만 입력되었습이다."),
                Arguments.of("rc1:rc2", "자동차 1대의 이름만 입력되었습이다."),
                Arguments.of(",rc1", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,,rc2", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1234,rc1,rc2", "5자 이상의 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,rc1234,rc2", "5자 이상의 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,rc2,rc1234", "5자 이상의 자동차 이름이 입력되었습니다.")
        );
    }

    @DisplayName("전진 시도 횟수 입력에 대한 검증 기능")
    @ParameterizedTest(name = "\"{0}\" 입력 : 예외메세지 - \"{1}\"")
    @MethodSource()
    void 전진_시도_횟수_입력에_대한_검증_기능(String roundCountInput, String expectedExceptionMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("rc1,rc2", roundCountInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(expectedExceptionMessage)
        );
    }

    private static Stream<Arguments> 전진_시도_횟수_입력에_대한_검증_기능() {
        return Stream.of(
                Arguments.of(" ", "비어있는 값이 입력되었습니다."),
                Arguments.of("two", "숫자가 아닌 값이 입력되었습니다."),
                Arguments.of("9999999999999", "Integer 범위를 벗어난 값이 입력되었습니다."),
                Arguments.of("-9999999999999", "Integer 범위를 벗어난 값이 입력되었습니다."),
                Arguments.of("0", "0보다 작은 값이 입력되었습니다."),
                Arguments.of("-1", "0보다 작은 값이 입력되었습니다.")
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
