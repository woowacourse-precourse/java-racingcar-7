package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("우승자가 여러명일 경우, 테스트")
    void end_to_end_test_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임의 시도 횟수가 0일 경우, 예외가 발생한다.")
    void end_to_end_test_2() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임의 시도 횟수가 음수일 경우, 예외가 발생한다.")
    void end_to_end_test_3() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임의 시도 횟수를 초과할 경우, 예외가 발생한다.")
    void end_to_end_test_4() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "4501"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Test
    @DisplayName("게임의 시도 횟수가 공백일 경우, 예외가 발생한다.")
    void end_to_end_test_5() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("게임의 시도 횟수가 숫자가 아닐 경우, 예외가 발생한다.")
    void end_to_end_test_6() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" pobi,woni ", "pobi, woni", "pobi, woni "})
    @DisplayName("자동차 이름 양 끝에 공백이 포함된 경우, 예외가 발생한다.")
    void end_to_end_test_7(String names) {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run(names, "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름이 주어지지 않는 경우, 예외가 발생한다.")
    void end_to_end_test_8() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("100대가 넘는 자동차가 주어질 경우, 예외가 발생한다.")
    void end_to_end_test_9() {
        String carNames = IntStream.range(0, 101)
                .mapToObj(i -> "a")
                .collect(Collectors.joining(","));

        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run(carNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("100대의 자동차가 주어질 경우, 500 라운드가 정상 동작한다.")
    void end_to_end_test_10() {
        String carNames = createCarNames();
        Integer[] values = moveCondition();
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, "500");
                    assertThat(output()).contains("0 : -", "최종 우승자 : 0");
                },
                MOVING_FORWARD,  values          // 첫 번째만 이동, 나머지 999대는 정지
        );
    }

    private static String createCarNames() {
        return IntStream.range(0, 100)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    private static Integer[] moveCondition() {
        return IntStream.range(0, 99)
                .mapToObj(i -> STOP)
                .toArray(Integer[]::new);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
