package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator("user1,user2,user3");
    }

    @Test
    @DisplayName("유저 이름이 빈 문자열일 때 예외 발생")
    void testIsEmptyName() {
        assertThatThrownBy(() -> validator.userNameValidate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저 이름이 최대 길이를 초과할 때 예외 발생")
    void testIsExceedMaxNameSize() {
        assertThatThrownBy(() -> validator.userNameValidate("username_too_long"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 문자열이 빈 문자열일 때 예외 발생")
    void testIsEmptyInput() {
        validator = new Validator("");
        assertThatThrownBy(validator::userInputValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 문자열의 처음이나 끝에 쉼표가 있을 때 예외 발생")
    void testIsCommaInFrontOrBack() {
        validator = new Validator(",user1,user2,user3,");
        assertThatThrownBy(validator::userInputValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 문자열이 최대 길이를 초과할 때 예외 발생")
    void testIsExceedMaxInputSize() {
        // 5100자 이상의 문자열을 생성하여 테스트
        String longInputString = "a".repeat(5100);
        validator = new Validator(longInputString);
        assertThatThrownBy(validator::userInputValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("tryNumber가 0 이하 또는 1000 초과일 때 예외 발생")
    void testIsValidateNumber() {
        // InputView.tryNumber를 0 이하 또는 1000 초과로 설정하고 테스트
        InputView.tryNumber = 0;
        assertThatThrownBy(Validator::isValidateNumber)
                .isInstanceOf(IllegalArgumentException.class);

        InputView.tryNumber = 1001;
        assertThatThrownBy(Validator::isValidateNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 입력이 주어졌을 때 예외 발생하지 않음")
    void testUserInputValidate_True() {
        validator = new Validator("user1,user2,user3");
        validator.userInputValidate();
    }

    @Test
    @DisplayName("유효한 유저 이름이 주어졌을 때 예외 발생하지 않음")
    void testUserNameValidate_True() {
        validator.userNameValidate("user1");
    }
}
