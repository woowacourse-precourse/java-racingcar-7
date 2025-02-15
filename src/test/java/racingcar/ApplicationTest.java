package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarNameValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("우승자가 두 명 이상인 경우")
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 에러 반환")
    void 자동차_이름_공백_제한_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 에러 반환")
    void 자동차_이름_공백_제한_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 에러 반환")
    void 자동차_이름_공백_제한_테스트3() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator validator = new CarNameValidator();
            validator.validate(null);
        });
    }

    @Test
    @DisplayName("자동차 이름이 중복인 경우 에러 반환")
    void 자동차_이름_중복_제한_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator validator = new CarNameValidator();
            validator.validate("pobi, pobi");
        });
    }

    @Test
    @DisplayName("시도 횟수에 음수를 입력한 경우 에러 반환")
    void 시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우 에러 반환")
    void 시도_횟수_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1.4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우 에러 반환")
    void 시도_횟수_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
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
