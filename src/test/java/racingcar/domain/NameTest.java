package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.CarValidationError;
import racingcar.model.Name;

class NameTest {

    @Test
    @DisplayName("이름이 null인 경우 예외가 발생해야 한다.")
    void nullNameExceptionTest() {
        // given, when, then
        assertThatThrownBy(() -> Name.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.NULL_OR_EMPTY_NAME_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("이름이 빈 문자열인 경우 예외가 발생해야 한다.")
    void emptyNameExceptionTest() {
        // given, when, then
        assertThatThrownBy(() -> Name.from(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.NULL_OR_EMPTY_NAME_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"name", "이름", "pobii", "포비입니다"})
    @DisplayName("이름은 영어 또는 한글로만 이루어져 있어야 한다.")
    void createNameTest(String value) {
        // given, when, then
        assertDoesNotThrow(() -> Name.from(value));
    }

    @Test
    @DisplayName("값이 동일할 경우 equals는 true를 반환해야 한다")
    void sameNameTest() {
        // given
        Name name = Name.from("name");
        Name sameName = Name.from("name");

        // then
        assertThat(name).isEqualTo(sameName);
    }

    @Test
    @DisplayName("값이 동일할 경우 hashCode도 동일해야 한다")
    void sameNameHashCodeTest() {
        // given
        Name name = Name.from("name");
        Name sameName = Name.from("name");

        // then
        assertThat(name.hashCode()).isEqualTo(sameName.hashCode());
    }

    @ParameterizedTest
    @ValueSource(strings = {"name.", "na me", "ㅎㄱㄷ", "홍길동!", " ", "name1"})
    @DisplayName("이름이 영어 또는 한글이 아니라면 예외가 발생해야 한다.")
    void nameFormExceptionTest(String value) {
        // when, then
        assertThatThrownBy(() -> Name.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.INVALID_NAME_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생해야 한다.")
    void nameLengthExceptionTest() {
        // given
        String value = "gildong";

        // when, then
        assertThatThrownBy(() -> Name.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.EXCEEDS_MAX_NAME_LENGTH_EXCEPTION.getMessage(5));
    }
}
