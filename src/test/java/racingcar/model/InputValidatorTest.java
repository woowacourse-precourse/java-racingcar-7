package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ExceptionMessage.DUPLICATION_NAME_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.EMPTY_NAME_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.INVALID_CHARACTER_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.NAME_LENGTH_OVER_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.NULL_INPUT_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("InputValidator_생성_테스트")
    @Test
    public void newInputValidator() {
        //given
        //when
        //then
        assertThat(inputValidator).isNotNull();
    }

    @DisplayName("InputValidator_생성_테스트")
    @Test
    public void isValidNamesTest() {
        //given
        String names = "pobi,woni,jun";
        //when
        //then
        assertThat(inputValidator.isValidNames(names)).isTrue();
    }

    @DisplayName("null_입력_예외_테스트")
    @Test
    public void NameForNullExceptionTest() {
        //given
        String input = null;
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_INPUT_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("빈이름_예외_테스트")
    @Test
    public void emptyNameExceptionTest() {
        //given
        String names = "aaaa,,aaaaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("이름_5자_초과_예외_테스트")
    @Test
    public void nameLengthOverExceptionTest() {
        //given
        String names = "aaaa,aaaaa,aaaaaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_OVER_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("앞공백_검사_테스트")
    @Test
    public void StartWhiteSpaceExceptionTest() {
        //given
        String names = "aaaa,aaaaa, aaaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("뒤공백_검사_테스트")
    @Test
    public void endWhiteSpaceExceptionTest() {
        //given
        String names = "aaaa,aaaaa,aaaa ";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("특수문자_포함_예외_테스트")
    @Test
    public void includeSpecialCharacterExceptionTest() {
        //given
        String names = "aaaa,aaaaa,a$aaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CHARACTER_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("제외문자_포함_예외_테스트")
    @Test
    public void includeExcludedCharacterExceptionTest() {
        //given
        String names = "aaaa,aaaaa,a_aaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CHARACTER_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("중복_이름_예외_테스트")
    @Test
    public void duplicationNameExceptionTest() {
        //given
        String names = "aaaa,aaaa,aaaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATION_NAME_EXCEPTION_MESSAGE.getMessage());
    }

    @DisplayName("null_입력_예외_테스트")
    @Test
    public void emptyExceptionTest() {
        //given
        String names = "aaaa,aaaa,aaaa";
        //when,then
        assertThatThrownBy(() -> inputValidator.isValidNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATION_NAME_EXCEPTION_MESSAGE.getMessage());
    }
}