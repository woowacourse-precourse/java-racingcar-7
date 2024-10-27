package racingcar;

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
    void testValidateDuplicateName() {
        //given
        List<Car> duplicateCars = List.of(new Car(new Name("pobi")), new Car(new Name("pobi")));

        //then
        assertThatThrownBy(() -> new Cars(duplicateCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
