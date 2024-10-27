package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarManagerTest {
    @Test
    void 자동차를_생성한다() {
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));

        // when
        RacingCarManager racingCarManager = new RacingCarManager(cars);

        // then
        assertThat(racingCarManager.getCars().size()).isEqualTo(3);
        assertThat(racingCarManager.getCars().get(0).getName()).isEqualTo("jang");
    }

    @Test
    void 자동차들을_이동시킨다() {
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));
        RacingCarManager racingCarManager = new RacingCarManager(cars);

        // when
        racingCarManager.moveCars(Arrays.asList(5, 1, 5));

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 가장_많이_이동한_자동차를_뽑는다(){
        // given
        List<Car> cars= Arrays.asList(new Car("jang"), new Car("jin"), new Car("young"));
        RacingCarManager racingCarManager = new RacingCarManager(cars);
        racingCarManager.moveCars(Arrays.asList(5, 1, 5));

        // when
        List<String>carNames = racingCarManager.findWinners();

        // then
        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames.get(1)).isEqualTo("young");
    }
}