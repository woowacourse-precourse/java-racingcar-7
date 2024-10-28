package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_NAME_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.NAME_DUPLICATE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"asd,asdasdasd,asd", "asdasd,asd,ds", ", ,", "asd, ,asdsa"})
    @DisplayName("0글자 미만, 5글자 초과된 이름이 있을 경우 예외를 발생한다.")
    void nameLengthValidate(String input) {
        assertThatThrownBy(() -> Parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa,aa,das", "ad,asd,asd"})
    @DisplayName("중복된 이름이 있는 경우 예외를 발생시킨다.")
    void duplicateNameValidate(String input) {
        assertThatThrownBy(() -> Parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("이름이 2개 미만인 경우 예외를 발생한다.")
    void nameCountValidate() {
        // given
        String input = "asd";
        // when & then
        assertThatThrownBy(() -> Parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_COUNT.getMessage());
    }

    @Test
    @DisplayName("정상적인 입력 값인 경우 String List를 반환한다.")
    void successParse() {
        // given
        String input = "asd,sad,aaa";
        // when
        List<String> names = Parser.parse(input);
        // then
        assertThat(names.size()).isEqualTo(3);
        assertThat(names).containsExactly("asd", "sad", "aaa");
    }

    @Test
    @DisplayName("이름 양 끝에 공백이 있는 경우 제거를 하여 이름들을 반환한다.")
    void successTrim() {
        // given
        String input = "asd  , sad ,  aaa   ";
        // when
        List<String> names = Parser.parse(input);
        // then
        assertThat(names.size()).isEqualTo(3);
        assertThat(names).containsExactly("asd", "sad", "aaa");
    }
}