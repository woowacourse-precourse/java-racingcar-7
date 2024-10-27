package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarListTest {

    @Test
    void 자동차_이름_테스트() {
        // Given
        String input = "pobi,woni,java";

        // When
        String[] result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobi", "woni", "java");
    }

    @Test
    void 자동차_이름_길이_테스트() {
        // Given
        String input = "pobi,woni,javaistoolong";

        // Then
        assertThatThrownBy(() -> CarList.carList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_경계_테스트() {
        // Given
        String input = "pobii, wonii ,javai, ja va";

        // When
        String[] result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobii", "wonii", "javai","ja va");
    }

    @Test
    void 자동차_이름_공백_테스트() {
        // Given
        String input = "pobi, ,java";

        // Then
        assertThatThrownBy(() -> CarList.carList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백을_포함한_자동차_이름_테스트() {
        // Given
        String input = "  pobi ,   woni ,   java   ";

        // When
        String[] result = CarList.carList(input);

        // Then
        assertThat(result).containsExactly("pobi", "woni", "java");
    }
}