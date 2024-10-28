package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

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
        Assertions.assertThatThrownBy(() -> CarValidator.validateNames(input)).isInstanceOf(IllegalArgumentException.class);
    }
}