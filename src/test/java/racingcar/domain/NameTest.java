package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    private static final String PREFIX_ERROR = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "jun", "woni", "Lim"})
    void 정상_이름_객체_생성(String input) {

        Name name = new Name(input);

        assertThat(name.getName()).isEqualTo(input);
    }

    @Test
    void 빈_문자열_예외() {

        String input = " ";

        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PREFIX_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "Lim.", "pobi2", "&#"})
    void 이름_영문자_예외(String input) {

        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PREFIX_ERROR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"LimJungHun", "Ronaldo", "KimJiMin"})
    void 이름_5글자초과_예외(String input) {

        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PREFIX_ERROR);
    }
}
