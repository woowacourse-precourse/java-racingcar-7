package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        Car car = new Car(new Name("test1"));
        Car car2 = new Car(new Name("test2"));
        Car car3 = new Car(new Name("test3"));
        car.forward(1);
        car2.forward(2);
        car3.forward(2);

        carList.add(car);
        carList.add(car2);
        carList.add(car3);

        cars = new Cars(carList);
    }

    @Test
    @DisplayName("size 출력 테스트")
    void testSize() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Car 리스트 반환 테스트")
    void testGetCars() {
        assertThat(cars.getCars()).isNotNull();
        assertThat(cars.getCars().toString()).contains("test1 : -", "test2 : --", "test3 : --");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차들 반환 테스트")
    void testFindFarthestCars() {
        assertThat(cars.findFarthestCars().toString()).contains("test2 : --", "test3 : --");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차 반환 테스트")
    void testFindFarthestCar() {
        assertThat(cars.findFarthestCar().toString()).isEqualTo("test2 : --");
    }
}
