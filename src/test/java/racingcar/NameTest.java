package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "java", "not"})
    void 정상_입력(String name) {
        Assertions.assertThat(new Name(name))
                .isInstanceOf(Name.class);
    }

    @DisplayName("이름 5자 이상인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"pobisd", "javajiji", "notToday"})
    void 이름이_5자보다_긴_입력(String name) {
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5자 이하여야 합니다.");
    }

    @DisplayName("이름 공백 입력")
    @Test
    void 이름이_공백_입력() {
        Assertions.assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백일 수 없습니다.");
    }

}