package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 자동차_이름은_null이어서는_안_된다() {
        assertThatThrownBy(() -> inputValidator.checkNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이어서는 안 됩니다.");
    }

    @Test
    void 자동차_이름은_최대_100개까지_입력할_수_있다() {
        String[] normalInput = new String[100];
        for (int i = 0; i < normalInput.length; i++) {
            normalInput[i] = String.valueOf(i);
        }

        String[] errorInput = new String[101];
        for (int i = 0; i < errorInput.length; i++) {
            errorInput[i] = String.valueOf(i);
        }

        inputValidator.checkMaxSize(normalInput);

        assertThatThrownBy(() -> inputValidator.checkMaxSize(errorInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 100개 이하로 입력되어야 합니다.");
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        String validName = "five5";
        String invalidName = "sixsix";

        inputValidator.checkNameLength(validName);

        assertThatThrownBy(() -> inputValidator.checkNameLength(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름은_1자_이상이어야_한다() {
        assertThatThrownBy(() -> inputValidator.checkEmptyName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름은_아스키코드여야_한다() {
        assertThatThrownBy(() -> inputValidator.checkAsciiCode("향미"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 아스키 코드여야 합니다.");
    }

    @Test
    void 자동차_이름이_공백_문자로만_이루어져_있어서는_안_된다() {
        assertThatThrownBy(() -> inputValidator.checkNotBlank(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");
    }

    @Test
    void 자동차_이름은_중복되어서는_안_된다() {
        String[] carNames = {"mimi", "jk", "mimi"};

        assertThatThrownBy(() -> inputValidator.checkDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 중복되어서는 안 됩니다.");
    }

    @Test
    void 시도_횟수는_null이어서는_안_된다() {
        assertThatThrownBy(() -> inputValidator.checkNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null이어서는 안 됩니다.");
    }

    @Test
    void 시도_횟수는_정수여야_한다() {
        assertThatThrownBy(() -> inputValidator.toInteger("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");

        assertThatThrownBy(() -> inputValidator.toInteger("1.54"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");
    }

    @Test
    void 시도_횟수는_양수여야_한다() {
        assertThatThrownBy(() -> inputValidator.checkRange(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    void 입력_가능한_최대_시도_횟수는_100이다() {
        assertThatThrownBy(() -> inputValidator.checkRange(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100이하여야 합니다.");
    }
}
