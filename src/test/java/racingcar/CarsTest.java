package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car.Car;
import racingcar.Car.CarName;
import racingcar.Car.Position;

public class CarsTest {

    @Test
    void testValidCarsCreation() {

        //given
        List<Car> validCars = List.of(new Car(new CarName("pobi")),new Car(new CarName("woni")));

        //when
        Cars cars = new Cars(validCars);

        //then
        assertThat(cars.getCarList()).hasSize(2);
    }

    @Test
    void testGetCarsPosition() {

        //given
        Cars cars = new Cars(List.of(new Car(new CarName("pobi"),new Position(0)), new Car(new CarName("woni"),new Position(1)),new Car(new CarName("jiny"),new Position(2))));
        List<Car> validCars = cars.getCarList();

        // when & then
        for (int i = 0; i < validCars.size(); i++) {
            Car car = validCars.get(i);
            assertThat(car.getPosition().getValue()).isEqualTo(i);
        }
    }

}
