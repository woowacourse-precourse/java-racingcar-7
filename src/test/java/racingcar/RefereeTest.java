package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @DisplayName("단독 우승자를 판단")
    @Test
    void findLoneWinnerTest() {
        // given
        Referee referee = new Referee();

        Car a = new Car("a");
        Car b = new Car("b");
        Car c = new Car("c");
        a.moveForward();

        // when
        List<Car> winners = referee.findWinners(Arrays.asList(a, b, c));

        // then
        assertThat(winners).containsExactly(a);
    }

    @DisplayName("공동 우승자를 판단")
    @Test
    void findWinnersTest() {
        // given
        Referee referee = new Referee();

        Car a = new Car("a");
        Car b = new Car("b");
        Car c = new Car("c");
        a.moveForward();
        b.moveForward();

        // when
        List<Car> winners = referee.findWinners(Arrays.asList(a, b, c));

        // then
        assertThat(winners).containsExactly(a, b);
    }

}