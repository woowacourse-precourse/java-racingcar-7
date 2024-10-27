package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(new Car(new Name("pobi")), new Car(new Name("woni")), new Car(new Name("crong"))));
    }

    @Test
    void testGetCars() {
        //given

        //when:
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList).hasSize(3);
    }

    @Test
    void testValidateDuplicateName() {
        //given
        List<Car> duplicateCars = List.of(new Car(new Name("pobi")), new Car(new Name("pobi")));

        //then
        assertThatThrownBy(() -> new Cars(duplicateCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetWinners() {
        //given
        List<Car> carList = cars.getCars();
        carList.get(0).position = 5;
        carList.get(1).position = 3;
        carList.get(2).position = 5;

        // when
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(car -> car.name.getName())
                .containsExactlyInAnyOrder("pobi", "crong");
    }
}
