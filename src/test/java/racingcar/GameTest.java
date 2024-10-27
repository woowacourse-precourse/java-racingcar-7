package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("자동차 경주 게임 생성")
    void createRacingGame() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
        Game game = new Game(cars, 5);

        assertThat(game).isNotNull();
    }

    @Test
    @DisplayName("우승자 결정 - 단독 우승")
    void findSingleWinner() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // car1이 더 많이 전진하도록 설정
        car1.move(4);
        car1.move(4);
        car2.move(4);

        Game game = new Game(Arrays.asList(car1, car2), 1);
        List<Car> winners = game.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자 결정 - 공동 우승")
    void findMultipleWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // 두 자동차가 같은 거리를 이동하도록 설정
        car1.move(4);
        car2.move(4);

        Game game = new Game(Arrays.asList(car1, car2), 1);
        List<Car> winners = game.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name")
                .containsExactlyInAnyOrder("pobi", "woni");
    }
}