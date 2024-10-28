package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("자동차 이름은 1~5자 알파벳(대소문자), 한글, 숫자, 언더바(_)로 이루어졌다")
    @ValueSource(strings = {"1", "p0비", "Poㅂ1_"})
    @ParameterizedTest
    void 자동차_이름_생성_성공(String value) {
        Name name = Name.from(value);

        assertThat(name.value()).isEqualTo(value);
    }

    @DisplayName("자동차 이름은 1자 미만, 5자 초과일 수 없다")
    @ValueSource(strings = {"", "_pobi_"})
    @ParameterizedTest
    void 자동차_생성_실패_범위를_벗어남(String value) {
        assertThatThrownBy(() -> Name.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자로 입력해주세요.");
    }

    @DisplayName("자동차 이름은 알파벳(대소문자), 한글, 숫자, 언더바(_)외 문자가 올 수 없다")
    @ValueSource(strings = {"!", "-", "+", "=", "(", "\""})
    @ParameterizedTest
    void 자동차_생성_실패_패턴_불일치(String value) {
        assertThatThrownBy(() -> Name.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영문(대소문자), 한글, 숫자, 언더바(_)만 입력해주세요.");
    }

}
