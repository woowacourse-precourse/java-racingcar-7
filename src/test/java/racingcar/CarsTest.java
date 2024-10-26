package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("Cars 리스트에 올바른 입력값이 들어갔을 때, 같은 크기의 리스트를 가진다.")
    @Test
    void Given_CorrectList_When_CarsHasInput_Then_SuccessWithSameSize() {
        // Given
        List<Name> input = Arrays.asList(new Name("aa"), new Name("bb"), new Name("cc"));

        // When
        Cars cars = new Cars(input);

        // Then
        assertThat(cars.getCars(input).size()).isEqualTo(input.size());
    }

    @DisplayName("")
    @Test
    void test() {
        // Given

        // When

        // Then
    }
}