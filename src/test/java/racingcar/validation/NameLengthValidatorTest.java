package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class NameLengthValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하일 경우 정상적으로 처리된다")
    void validateValidNames() {
        ArrayList<String> validNames = new ArrayList<>(Arrays.asList("car1", "car2", "car3"));

        assertThatCode(() -> nameLengthValidator.validate(validNames))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다")
    void validateInvalidNameLength() {
        ArrayList<String> invalidNames = new ArrayList<>(List.of("car123456"));

        assertThatThrownBy(() -> nameLengthValidator.validate(invalidNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car123456", "vehicle1", "longname"})
    @DisplayName("5자를 초과하는 다양한 이름들에 대해 예외가 발생한다")
    void validateMultipleInvalidNames(String invalidName) {
        // given
        ArrayList<String> names = new ArrayList<>(Arrays.asList(invalidName));

        // when & then
        assertThatThrownBy(() -> nameLengthValidator.validate(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("여러 자동차 이름 중 하나라도 5자를 초과할 경우 예외가 발생한다")
    void validateMixedNames() {
        ArrayList<String> mixedNames = new ArrayList<>(Arrays.asList("car1", "car123456", "car2"));

        assertThatThrownBy(() -> nameLengthValidator.validate(mixedNames))
            .isInstanceOf(IllegalArgumentException.class);
    }
}