package racingcar.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.name.Name;
import racingcar.name.Names;

class CarsTest {

    @DisplayName("Cars 리스트에 올바른 입력값이 들어갔을 때, 같은 크기의 리스트를 가진다.")
    @Test
    void Given_CorrectList_When_CarsHasInput_Then_SuccessWithSameSize() {
        // Given
        List<Name> input = Arrays.asList(new Name("aa"), new Name("bb"), new Name("cc"));
        Names names = new Names("aa,bb,cc");
        // When
        Cars cars = new Cars(names);

        // Then
        assertThat(cars.carsSize()).isEqualTo(input.size());
    }
}