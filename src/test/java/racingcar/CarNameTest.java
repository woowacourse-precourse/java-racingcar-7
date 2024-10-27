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
        List<String> result = CarName.carNameFilter(input);

        // Then
        Assertions.assertThat(result).contains("pobi", "jun");
    }

    @Test
    void carsException() {
        // Given
        String input = "pobiii,jun";

        // When


        // Then
        Assertions.assertThatThrownBy(() -> CarName.carNameFilter(input)).isInstanceOf(IllegalArgumentException.class);
    }
}