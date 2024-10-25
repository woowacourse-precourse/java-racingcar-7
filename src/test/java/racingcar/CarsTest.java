package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void testValidCarsCreation() {

        //given
        List<Car> validCars = List.of(new Car("pobi"), new Car("woni"));

        //when
        Cars cars = new Cars(validCars);

        //then
        assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    void testGetCarsPosition() {

        //given
        Cars cars = new Cars(List.of(new Car("pobi",0), new Car("woni",1), new Car("jiny",2)));
        List<Car> validCars = cars.getCarList();

        //when & then
        for(Car car : validCars) {
            assertThat(car.getPosition()).isEqualTo(validCars.indexOf(car.getName()));
        }
    }

}
