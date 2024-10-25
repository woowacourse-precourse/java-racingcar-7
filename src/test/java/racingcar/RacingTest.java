package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    void testRacingCreation() {

        //given
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
        int validRounds = 3;

        //when
        Racing racing = new Racing(cars ,validRounds);

        //then
        assertThatCode(() -> racing.process()).doesNotThrowAnyException();
    }

    @Test
    void testGetRacingWinner() {

        //given
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni"), new Car("jun")));
        Racing racing = new Racing(cars, 5);

        //when
        racing.process();

        //then
        List<Car> winners = racing.getWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.size()).isGreaterThan(0);
    }
}
