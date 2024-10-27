package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    @Test
    void 자동차를_생성한다() {
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));

        // when
        CarManager carManager = new CarManager(cars);

        // then
        assertThat(carManager.getCars().size()).isEqualTo(3);
        assertThat(carManager.getCars().get(0).getName()).isEqualTo("jang");
    }
}