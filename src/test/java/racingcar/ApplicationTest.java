package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    @DisplayName("자동차 이름이 중복될 경우 예외 발생")
    void 중복_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 중복될 수 없습니다: pobi")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("양수가 아닌 시도 횟수 입력에 대해 예외 발생")
    void 양수가_아닌_시도_횟수_입력_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상의 자연수여야 합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "*"})
    @DisplayName("숫자가 아닌 시도 횟수 입력에 대해 예외 발생")
    void 숫자가_아닌_시도_횟수_입력_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 숫자여야 합니다.")
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"\n", " "})
    @DisplayName("자동차 이름이 빈 문자열 또는 공백일 경우 예외 발생")
    void 빈문자열_공백_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    void 이름_길이_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 최대 길이인 5자인 경우 정상적으로 작동")
    void 최대_길이_이름_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abcde,pobi", "1");
                    assertThat(output()).contains("abcde : -", "pobi : ", "최종 우승자 : abcde, pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차가 하나일 때도 정상적으로 동작")
    void 단일_자동차_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "3");
                    assertThat(output()).contains("pobi : -", "pobi : --", "pobi : ---", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 5개일 때 정상적으로 동작")
    void 다수_자동차_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("Car1,Car2,Car3,Car4,Car5", "2");
                    assertThat(output()).contains(
                            "Car1 : -", "Car2 : -", "Car3 : -", "Car4 : -", "Car5 : -",
                            "Car1 : --", "Car2 : --", "Car3 : --", "Car4 : --", "Car5 : --"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
