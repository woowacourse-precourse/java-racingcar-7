package racingcar.service;

import racingcar.model.Racingcar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarServiceImplTest {
    private RacingcarService racingcarService;

    @BeforeEach
    void setUp() {
        racingcarService = RacingcarServiceImpl.getInstance();
    }

    @Test
    void 경주_실행_후_거리_0이상() {
        // Given
        Racingcar car1 = new Racingcar("a");
        Racingcar car2 = new Racingcar("b");
        List<Racingcar> racingcars = Arrays.asList(car1, car2);

        // When
        racingcarService.startRaceByCount(racingcars);

        // Then
        assertThat(car1.getDistance()).isGreaterThanOrEqualTo(0);
        assertThat(car2.getDistance()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 거리_최대인_자동차가_우승자() {
        // Given
        Racingcar car1 = new Racingcar("a");
        Racingcar car2 = new Racingcar("b");
        Racingcar car3 = new Racingcar("c");

        car1.setDistance(10);
        car2.setDistance(5);
        car3.setDistance(2);
        List<Racingcar> racingcars = Arrays.asList(car1, car2, car3);

        // When
        List<Racingcar> winners = racingcarService.determineWinner(racingcars);

        // Then
        assertThat(winners).containsExactlyInAnyOrder(car1);
    }
}
