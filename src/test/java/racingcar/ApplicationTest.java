package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @ParameterizedTest
    @DisplayName("입력이 비었으면 예외")
    @CsvSource({
            "'', '1'",
            "'pobi,woni', ' '",
    })
    void 입력이_비었으면_예외(String carsInput, String roundNumberInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carsInput, roundNumberInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 비었으면 예외")
    void 자동차_이름이_비었으면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외")
    void 자동차_이름이_중복되면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상이면 예외")
    void 자동차_이름이_6자_이상이면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("입력값 시작이나 끝이 쉼표이면 예외")
    @CsvSource({
            "',pobi,woni', '1'",
            "'pobi,woni,', '1'",
    })
    void 입력값_시작이나_끝이_쉼표이면_예외(String carsInput, String roundNumberInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carsInput, roundNumberInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 입력값이 자연수가 아니면 예외")
    @CsvSource({
            "'pobi,woni', '-1'",
            "'pobi,woni', '0'",
            "'pobi,woni', 'a'"
    })
    void 시도_횟수_입력값이_자연수가_아니면_예외(String carsInput, String roundNumberInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carsInput, roundNumberInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 10이 넘으면 예외")
    void 시도_횟수가_10이_넘으면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "20"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}