package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"));
        assertThat(new Cars(carList)).isEqualTo(new Cars(carList));
    }
}
