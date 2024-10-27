package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 자동차를_생성한다() {
        // given
        List<String> carNames= Arrays.asList("jang", "jin", "young");

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("jang");
    }

    @Test
    void 자동차들을_이동시킨다() {
        // given
        List<String> carNames= Arrays.asList("jang", "jin", "young");
        Cars cars = new Cars(carNames);

        // when
        cars.moveCars(Arrays.asList(5, 1, 5));

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 가장_많이_이동한_자동차를_뽑는다(){
        // given
        List<String> carNames= Arrays.asList("jang", "jin", "young");
        Cars cars = new Cars(carNames);
        cars.moveCars(Arrays.asList(5, 1, 5));

        // when
        List<String> winnerNames = cars.findWinners();

        // then
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames.get(1)).isEqualTo("young");
    }
}