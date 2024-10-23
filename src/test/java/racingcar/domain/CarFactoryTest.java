package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {
    @Test
    void 자동차들_생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        assertThat(CarFactory.createCars("pobi,woni,jun")).isEqualTo(new Cars(carList));
    }

}
