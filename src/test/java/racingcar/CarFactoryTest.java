package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {

    private final CarFactory carFactory = new CarFactory();
    private final List<String> carNames = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
    }

    @Test
    @DisplayName("경주 자동차 객체 생성 테스트")
    public void createCar() {

        List<Car> cars = carFactory.createCars(carNames);

        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");

    }
}
