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

    @Test
    void 자동차들을_이동시킨다() {
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));
        CarManager carManager = new CarManager(cars);

        // when
        carManager.moveCars(Arrays.asList(5, 1, 5));

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 가장_많이_이동한_자동차를_뽑는다(){
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));
        CarManager carManager = new CarManager(cars);
        carManager.moveCars(Arrays.asList(5, 1, 5));

        // when
        List<String>carNames = carManager.findWinners();

        // then
        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames.get(1)).isEqualTo("young");
    }
}