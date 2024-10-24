package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "jun", "woni", "Lim"})
    void 정상_이름_객체_생성(String input) {
        //given
        Name name = new Name(input);

        //when

        //then
        assertThat(name.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 빈_문자열_예외(String input) {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]이름은 빈 문자열일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "Lim.", "pobi2", "&#"})
    void 이름_영문자_예외(String input) {
        //then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]이름은 영문자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"LimJungHun", "Ronaldo", "KimJiMin"})
    void 이름_5글자초과_예외(String input) {
        //then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]이름은 5글자를 초과할 수 없습니다.");
    }
}
