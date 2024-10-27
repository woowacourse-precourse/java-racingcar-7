package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void 유효한_길이의_이름으로_객체를_생성한다(String validName) {
        // when
        Name name = Name.from(validName);

        // then
        assertThat(name.getValue()).isEqualTo(validName);
    }

    @Test
    void 빈_문자열로_객체를_생성할_수_없다() {
        // given
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> Name.from(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_LENGTH.format(1, 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg", "abcdefgh", "abcdefghi"})
    void 최대_길이를_초과하는_이름으로_객체를_생성할_수_없다(String longName) {
        // when & then
        assertThatThrownBy(() -> Name.from(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_LENGTH.format(1, 5));
    }

    @Test
    void null_값으로_객체를_생성할_수_없다() {
        // when & then
        assertThatThrownBy(() -> Name.from(null))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나", "가나다", "가나다라", "가나다라마"})
    void 한글_이름으로_객체를_생성할_수_있다(String koreanName) {
        // when
        Name name = Name.from(koreanName);

        // then
        assertThat(name.getValue()).isEqualTo(koreanName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "1b", "123", "1가나", "12345"})
    void 숫자가_포함된_이름으로_객체를_생성할_수_있다(String nameWithNumber) {
        // when
        Name name = Name.from(nameWithNumber);

        // then
        assertThat(name.getValue()).isEqualTo(nameWithNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a b", "a\tb", "a\nb", " abc", "abc "})
    void 공백이_포함된_이름으로_객체를_생성할_수_있다(String nameWithSpace) {
        // when
        Name name = Name.from(nameWithSpace);

        // then
        assertThat(name.getValue()).isEqualTo(nameWithSpace);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a!b", "a@b", "a#b", "a$b", "a%b"})
    void 특수문자가_포함된_이름으로_객체를_생성할_수_있다(String nameWithSpecialChar) {
        // when
        Name name = Name.from(nameWithSpecialChar);

        // then
        assertThat(name.getValue()).isEqualTo(nameWithSpecialChar);
    }

    @Test
    void 이름_객체는_불변이다() {
        // given
        String value = "name";
        Name name = Name.from(value);

        // when
        value = "changed";

        // then
        assertThat(name.getValue()).isEqualTo("name");
    }

    @Test
    void 유니코드_이모지가_포함된_이름으로_객체를_생성할_수_있다() {
        // given
        String nameWithEmoji = "a😊b";

        // when
        Name name = Name.from(nameWithEmoji);

        // then
        assertThat(name.getValue()).isEqualTo(nameWithEmoji);
    }
}
