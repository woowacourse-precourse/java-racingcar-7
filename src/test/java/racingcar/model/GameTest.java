package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Cars cars = new Cars(List.of(car1, car2));
        game = new Game(cars, 5);
    }

    @Test
    @DisplayName("게임 라운드 수 반환 테스트")
    void getGameRoundTest() {
        Integer gameRound = game.getGameRound();
        assertThat(gameRound).isEqualTo(5);
    }
}
