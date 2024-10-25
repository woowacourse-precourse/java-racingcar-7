package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 이름_앞뒤_공백_제거_검증() {
        String carNames = " pobi   , jun,jenny ";
        assertThat(Application.isValidName(carNames)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" po bi , jun,jenny", " po bi ,ju  n "})
    void 이름_내_공백_허용_검증(String carNames) {
        assertThat(Application.isValidName(carNames)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" pobi* , jun1,je+ny", "**, +++,car2", "po b2 , j@@n, (**)"})
    void 이름_내_기호_허용_검증(String carNames) {
        assertThat(Application.isValidName(carNames)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" 2", "3 ", " 4 "})
    void 시도횟수_앞뒤_공백_제거_검증(String attemptCount) {
        assertThat(Application.isValidAttemptCount(attemptCount)).isTrue();
    }

    @Test
    void 예외_테스트_이름5자초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" pobi , junnnn,jenny ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" po  bi , jun,jenny ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" po  bi , ju   n,jenny", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_이름누락() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른구분자사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.jun.jenny", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.jun;jenny", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_이름미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_이름중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_쉼표로끝나는경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_참가자동차1대() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("*", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수가_0인경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수가_소수인경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "3.4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "0.7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수가_음수인경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수가_입력되지않은경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수가_숫자가아닌경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "*"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "3 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,", "3*3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
