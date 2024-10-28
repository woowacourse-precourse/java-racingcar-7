package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static Cars cars;

    @BeforeAll
    static void setup() {
        cars = new Cars(List.of("car1", "car2", "car3"));
    }

    @DisplayName("각 자동차 포지션을 반환한다")
    @Test
    void carsReturnsPositions() {
        cars.progressRound();
        List<Integer> positions = cars.getPositions();
        assertThat(positions).hasSize(3);
    }

    @DisplayName("우승자를 결정한다")
    @Test
    void carsDeterminesWinners() {
        List<String> winners = cars.getWinners();
        assertThat(winners).isNotEmpty();
    }
}
