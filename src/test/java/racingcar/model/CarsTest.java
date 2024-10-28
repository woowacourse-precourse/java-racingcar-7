package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars();
    }

    @Test
    void 자동차를_저장한다() {
        cars.saveCar(new Car("pobi"));
        cars.saveCar(new Car("jun"));
        List<CarDto> carDtoList = Arrays.asList(
                new CarDto("pobi", 0),
                new CarDto("jun", 0)
        );

        assertThat(cars.getCarDtoList())
                .isEqualTo(carDtoList);
    }

    @Test
    void 저장하는_자동차_이름이_중복이면_예외() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");
        cars.saveCar(car1);

        assertThatThrownBy(() ->
                cars.saveCar(car2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_DUPLICATE_EXCEPTION.message());
    }

    @Test
    void 자동차들을_전진시킨다() {
        TestCar car1 = new TestCar("poby");
        TestCar car2 = new TestCar("jun");
        car1.setRandomNumber(7);
        car2.setRandomNumber(2);

        cars.saveCar(car1);
        cars.saveCar(car2);

        List<CarDto> carDtoList = Arrays.asList(
                new CarDto("poby", 1),
                new CarDto("jun", 0)
        );

        cars.moveCars();

        assertThat(cars.getCarDtoList())
                .isEqualTo(carDtoList);
    }

    @Test
    void 우승한_자동차들의_이름을_계산한다() {
        TestCar car1 = new TestCar("poby");
        TestCar car2 = new TestCar("woni");
        TestCar car3 = new TestCar("jun");
        car1.setRandomNumber(7);
        car2.setRandomNumber(2);
        car3.setRandomNumber(6);

        cars.saveCar(car1);
        cars.saveCar(car2);
        cars.saveCar(car3);

        List<String> winnerNameList = Arrays.asList("poby", "jun");

        cars.moveCars();
        cars.moveCars();

        assertThat(cars.getWinnerNames())
                .isEqualTo(winnerNameList);
    }
}
