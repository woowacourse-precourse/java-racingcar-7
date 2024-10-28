package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.executor.decider.winner.WinnerListDeciderImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WinnerListDeciderTest {
    private WinnerListDeciderImpl winnerListDecider;

    @BeforeEach
    public void setUp() {
        winnerListDecider = new WinnerListDeciderImpl();
    }

    @DisplayName("단독 우승자 1명을 제대로 도출해 내는지 Test")
    @Test
    public void findWinners_ShouldReturnSingleWinner_WhenOneCarHasMaxDistance() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.move();
        car1.move();
        car2.move();
        List<Car> racingHistory = List.of(car1, car2);

        List<String> winners = winnerListDecider.findWinners(racingHistory);

        assertThat(winners).containsExactly("Car1");
    }

    @DisplayName("공동 우승자 2명을 제대로 도출해 내는지 Test")
    @Test
    public void findWinners_ShouldReturnMultipleWinners_WhenMultipleCarsHaveMaxDistance() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        car1.move();
        car1.move();
        car2.move();
        car2.move();
        car3.move();
        List<Car> racingHistory = List.of(car1, car2, car3);

        List<String> winners = winnerListDecider.findWinners(racingHistory);

        assertThat(winners).containsExactlyInAnyOrder("Car1", "Car2");
    }
}
