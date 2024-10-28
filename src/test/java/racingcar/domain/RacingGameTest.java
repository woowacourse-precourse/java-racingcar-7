package racingcar.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("게임은 총 시도할 횟수만큼 진행된다.")
    void gameShouldRunTotalRounds() {
        List<Car> cars = Car.createCars(Arrays.asList("pobi", "crong"));
        RacingGame game = new RacingGame(cars, 5);
        int rounds = 0;
        while (game.hasNextRound()) {
            game.playRound();
            rounds++;
        }
        assertThat(rounds).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자는 가장 앞선 위치에 있는 모든 자동차이다.")
    void winnersShouldBeCarsWithMaxPosition() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move(4); // position = 1
        car2.move(4); // position = 1
        List<Car> cars = Arrays.asList(car1, car2);
        RacingGame game = new RacingGame(cars, 1);
        List<String> winners = game.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong");
    }
}