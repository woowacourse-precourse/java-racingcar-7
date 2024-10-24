package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "})
    @DisplayName("입력 값이 비어있는 경우 예외가 발생한다.")
    void validateNonEmpty(String candidate) {
        assertThatThrownBy(() -> Input.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi:woni:jun",
            "pobi.woni.jun",
            "pobi+woni+jun"})
    @DisplayName("구분자가 쉼표가 아닌 경우 예외가 발생한다.")
    void validateDelimiter(String candidate) {
        assertThatThrownBy(() -> Input.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 쉼표로 구분된 영어 이름만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "우아한,테크,코스",
            "우아한.테크.코스",
            "우아한-테크-코스"})
    @DisplayName("자동차 이름이 영어가 아닌 경우 예외가 발생한다.")
    void validateNonEnglishNames(String candidate) {
        assertThatThrownBy(() -> Input.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 쉼표로 구분된 영어 이름만 가능합니다.");
    }

}