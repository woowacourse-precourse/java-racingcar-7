package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;
    private String[] names;

    @BeforeEach
    void setUp() {
        names = new String[]{"pobi", "woni", "jun"};
        cars = new Cars(
                names
        );
    }

    @Test
    @DisplayName("중복된 이름을 입력하는 경우 예외가 발생한다.")
    void throwExceptionWhenNamesAreDuplicated() {
        // given
        String name = "pobi";
        String[] duplicatedNames = {name, name, name};

        // when & then
        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차의 이름을 반환한다.")
    void returnNameOfCarWhenItHasMaxPosition() {
        // given
        int indexOfMaxPositionCar = 0;

        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);

        // when
        List<String> nameOfMaxPositionCars = cars.getNameOfMaxPositionCars();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(1),
                () -> assertThat(nameOfMaxPositionCars.get(indexOfMaxPositionCar)).isEqualTo(
                        names[indexOfMaxPositionCar])
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러대일 경우 여러개의 이름을 반환한다.")
    void returnNamesOfCarsWhenTheyHaveMaxPosition() {
        // given
        int indexOfFirstMaxPositionCar = 0;
        int indexOfSecondMaxPositionCar = 1;
        int sizeOfMaxPositionCars = 2;

        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);

        // when
        List<String> nameOfMaxPositionCars = cars.getNameOfMaxPositionCars();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(sizeOfMaxPositionCars),
                () -> assertThat(nameOfMaxPositionCars).isEqualTo(
                        List.of(names[indexOfFirstMaxPositionCar], names[indexOfSecondMaxPositionCar]))
        );
    }

}
