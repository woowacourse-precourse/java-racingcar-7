package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void 자동차들을_전진시킨다() {

    }
}
