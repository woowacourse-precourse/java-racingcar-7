package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;
import racingcar.domain.RandomNumberGenerator;
import racingcar.mock.TestRandomNumberGenerator;
import racingcar.utils.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("MCshin00");

        assertThat(car.getName()).isEqualTo("MCshin00");
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        Car car = new Car("MCshin00");
        Car car2 = new Car("asdf1234");
        RandomGenerator randomNumberGenerator = new RandomNumberGenerator();
        CarList carList = new CarList(List.of(car, car2), randomNumberGenerator);

        List<String> carNames = List.of("MCshin00", "asdf1234");

        assertThat(carList.getCarList().stream()
                .map(Car::getName))
                .containsExactlyElementsOf(carNames);
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("MCshin00");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("MCshin00");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전체_이동_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        CarList carList = new CarList(cars, testRandomNumberGenerator);

        carList.moveAll();

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
