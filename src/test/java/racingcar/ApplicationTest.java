package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차_이름은_null이어서는_안_된다() {
        assertThatThrownBy(() -> Application.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 null이어서는 안 됩니다.");
    }

    @Test
    void 자동차_이름은_최대_100개까지_입력할_수_있다() {
        StringBuilder normalInput = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            normalInput.append(i + ",");
        }
        normalInput.deleteCharAt(normalInput.length() - 1);
        StringBuilder errorInput = new StringBuilder();
        for (int i = 1; i <= 101; i++) {
            errorInput.append(i + ",");
        }
        errorInput.deleteCharAt(errorInput.length() - 1);
        assertThat(Application.validateCarNames(normalInput.toString())).hasSize(100);

        assertThatThrownBy(() -> Application.validateCarNames(errorInput.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 100개 이하로 입력되어야 합니다.");
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        assertThat(Application.validateCarNames("a,b,c,d,e")).hasSize(5);
        assertThat(Application.validateCarNames("a.,b,c,d,e")).hasSize(5);
        assertThat(Application.validateCarNames("a ,b,c,d,e")).hasSize(5);
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        assertThat(Application.validateCarNames("five5")).hasSize(1);

        assertThatThrownBy(() -> Application.validateCarNames("sixsix"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름은_1자_이상이어야_한다() {
        assertThatThrownBy(() -> Application.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> Application.validateCarNames(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> Application.validateCarNames(",a,b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> Application.validateCarNames("a,b,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름은_아스키코드여야_한다() {
        assertThatThrownBy(() -> Application.validateCarNames("향미,종현,영서,병규"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 아스키 코드여야 합니다.");
    }

    @Test
    void 자동차_이름이_공백_문자로만_이루어져_있어서는_안_된다() {
        assertThatThrownBy(() -> Application.validateCarNames(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> Application.validateCarNames("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> Application.validateCarNames("mimi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> Application.validateCarNames("    ,mimi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");
    }

    @Test
    void 자동차_이름은_중복되어서는_안_된다() {
        assertThatThrownBy(() -> Application.validateCarNames("mimi,jk,mimi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 중복되어서는 안 됩니다.");
    }

    @Test
    void 시도_횟수는_정수여야_한다() {
        assertThatThrownBy(() -> Application.validateCount("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");

        assertThatThrownBy(() -> Application.validateCount("1.54"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");
    }

    @Test
    void 시도_횟수는_양수여야_한다() {
        assertThatThrownBy(() -> Application.validateCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    void 입력_가능한_최대_시도_횟수는_100이다() {
        assertThatThrownBy(() -> Application.validateCount("101"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100이하여야 합니다.");
    }
}
