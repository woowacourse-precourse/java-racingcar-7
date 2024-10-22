package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    void 우승자_구하기() {
        Cars cars = new Cars(List.of(new Car("hwan2",3), new Car("hwan3",1)));
        Winners winners = new Winners(cars);
        assertThat(winners.getWinners()).containsExactly(cars.getCars().getFirst());
    }
}