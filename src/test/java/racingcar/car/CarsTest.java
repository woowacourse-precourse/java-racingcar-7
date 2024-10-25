package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 레이싱_참가_자동차_toString_반환() {
        List<String> names = List.of("pobi","woni");
        Cars cars = new Cars(names);

        assertThat(cars.toString()).isEqualTo("pobi : \nwoni : ");
    }

    @Test
    void 레이싱_위너_자동차_반환() {
        List<String> names = List.of("pobi","woni");
        Cars cars = new Cars(names);

        assertThat(cars.getRacingWinners()).contains("pobi","woni");
    }

    @Test
    void 참가한_자동차가_없는_경우() {
        List<String> names = List.of();
        Cars cars = new Cars(names);

        assertThatThrownBy(cars::getRacingWinners)
                .isInstanceOf(IllegalArgumentException.class);
    }
}