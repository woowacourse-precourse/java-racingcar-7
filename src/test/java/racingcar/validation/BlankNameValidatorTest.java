package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class BlankNameValidatorTest {

    @Test
    @DisplayName("공백이 없는 자동차 이름들은 정상적으로 처리된다")
    void validateNamesWithoutBlank() {
        ArrayList<String> validNames = new ArrayList<>(Arrays.asList("car1", "car2", "car3"));

        assertThatCode(() -> BlankNameValidator.validate(validNames))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "car 1",        // 중간 공백
        " car1",        // 처음 공백
        "car1 ",        // 마지막 공백
        "c a r 1"       // 여러개 공백
    })
    @DisplayName("이름에 공백이 포함된 경우 예외가 발생한다")
    void validateNameWithBlank(String nameWithBlank) {
        ArrayList<String> names = new ArrayList<>(Collections.singletonList(nameWithBlank));

        assertThatThrownBy(() -> BlankNameValidator.validate(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("여러 이름 중 하나라도 공백이 포함된 경우 예외가 발생한다")
    void validateMixedNames() {
        ArrayList<String> mixedNames = new ArrayList<>(Arrays.asList("car1", "car 2", "car3"));

        assertThatThrownBy(() -> BlankNameValidator.validate(mixedNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특수문자가 포함된 이름도 공백이 아니면 정상 처리된다")
    void validateNameWithSpecialCharacters() {
        ArrayList<String> namesWithSpecialChars = new ArrayList<>(Arrays.asList("car#1", "car@2", "car$3"));

        assertThatCode(() -> BlankNameValidator.validate(namesWithSpecialChars))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("한글이 포함된 이름도 공백이 아니면 정상 처리된다")
    void validateNameWithKorean() {
        ArrayList<String> namesWithKorean = new ArrayList<>(Arrays.asList("자동차1", "차2", "카3"));

        assertThatCode(() -> BlankNameValidator.validate(namesWithKorean))
            .doesNotThrowAnyException();
    }
}
