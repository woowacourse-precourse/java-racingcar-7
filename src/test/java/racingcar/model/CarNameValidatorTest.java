package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CarNameValidatorTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 이름 입력 값 자체가 빈 문자열(\"\")인 경우")
    void 자동차_이름_입력이_빈_문자열_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열(\"\")인 것이 포함된 경우")
    void 자동차_이름_입력이_빈_문자열_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hail,,cool", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백(\" \")인 것이 포함된 경우")
    void 자동차_이름_입력이_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hail,   ,cool", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 영어로만 입력되지 않은 경우")
    void 자동차_이름_영어가_아닌_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("hail, 핼리", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 경주할 자동차 이름을 영어로만 입력해 주세요.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    void 자동차_이름_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hailey", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 경주할 자동차 이름을 5자 이하로 입력해 주세요.")
        );
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우")
    void 자동차_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hail,hail,hail", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 경주할 자동차 이름이 중복되었습니다.")
        );
    }

    @Test
    @DisplayName("자동차 이름을 정상적으로 입력한 경우")
    void 자동차_이름_정상적() {
        assertRandomNumberInRangeTest (
            () -> {
                assertThatCode(() -> {
                    run("hail,good", "2");
                    assertThat(output()).contains("hail : --", "good : ", "최종 우승자 : hail");
                }).doesNotThrowAnyException();
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}