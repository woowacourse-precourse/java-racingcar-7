package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    // 테스트 메서드 이름은 "클래스 메서드 이름_예외 상황 설명식"으로 짓고 시나리오는 @DisplayName으로?
    // 특정 메서드를 테스트한단 걸 더 잘 알 수 있게!!
    @Test
    void 자동차_이름은_null이어서는_안_된다() {
        assertThatThrownBy(() -> inputParser.executeCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이어서는 안 됩니다.");
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
        assertThat(inputParser.executeCarNames(normalInput.toString())).hasSize(100);

        assertThatThrownBy(() -> inputParser.executeCarNames(errorInput.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 100개 이하로 입력되어야 합니다.");
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        assertThat(inputParser.executeCarNames("a,b,c,d,e")).hasSize(5);
        assertThat(inputParser.executeCarNames("a.,b,c,d,e")).hasSize(5);
        assertThat(inputParser.executeCarNames("a ,b,c,d,e")).hasSize(5);
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        assertThat(inputParser.executeCarNames("five5")).hasSize(1);

        assertThatThrownBy(() -> inputParser.executeCarNames("sixsix"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름은_1자_이상이어야_한다() {
        assertThatThrownBy(() -> inputParser.executeCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames(",a,b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames("a,b,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름은_아스키코드여야_한다() {
        assertThatThrownBy(() -> inputParser.executeCarNames("향미,종현,영서,병규"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 아스키 코드여야 합니다.");
    }

    @Test
    void 자동차_이름이_공백_문자로만_이루어져_있어서는_안_된다() {
        assertThatThrownBy(() -> inputParser.executeCarNames(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames("mimi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");

        assertThatThrownBy(() -> inputParser.executeCarNames("    ,mimi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");
    }

    @Test
    void 자동차_이름은_중복되어서는_안_된다() {
        assertThatThrownBy(() -> inputParser.executeCarNames("mimi,jk,mimi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 중복되어서는 안 됩니다.");
    }

    @Test
    void 시도_횟수는_null이어서는_안_된다() {
        assertThatThrownBy(() -> inputParser.executeAttempts(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이어서는 안 됩니다.");
    }

    @Test
    void 시도_횟수는_정수여야_한다() {
        assertThatThrownBy(() -> inputParser.executeAttempts("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");

        assertThatThrownBy(() -> inputParser.executeAttempts("1.54"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");
    }

    @Test
    void 시도_횟수는_양수여야_한다() {
        assertThatThrownBy(() -> inputParser.executeAttempts("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    void 입력_가능한_최대_시도_횟수는_100이다() {
        assertThatThrownBy(() -> inputParser.executeAttempts("101"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100이하여야 합니다.");
    }
}
