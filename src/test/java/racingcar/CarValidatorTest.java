package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarValidatorTest {

    @Test
    void cars() {
        // Given
        String input = "pobi,jun";

        // When
        List<String> result = CarValidator.validateNames(input);

        // Then
        Assertions.assertThat(result).contains("pobi", "jun");
    }

    @Test
    void carsException() {
        // Given
        String input = "pobiii,jun";

        // When


        // Then
        Assertions.assertThatThrownBy(() -> CarValidator.validateNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 5자 이내여야 합니다.");
    }

    @Test
    void blankValidator() {
        // Given
        String input = "pobi , jun ";

        // When
        List<String> result = CarValidator.validateNames(input);

        // Then
        Assertions.assertThat(result).contains("pobi", "jun");
    }


    @Test
    void sameNameException() {
        // Given
        String input = "pobi,pobi";

        // When


        // Then
        Assertions.assertThatThrownBy(() -> CarValidator.validateNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 겹치는 이름이 있습니다.");
    }
}