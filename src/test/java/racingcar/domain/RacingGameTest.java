package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("1"), new Car("2"), new Car("3"));
    }

    @Test
    void 정상적인_레이싱_게임_시작() {
        // given
        int gameRound = 5;
        RacingGame racingGame = new RacingGame(cars, gameRound);

        // when
        racingGame.play();
    }

    @Test
    void 예외_중복되는_자동차_이름() {
        // given
        int gameRound = 5;
        List<Car> overlappingNamesCars = List.of(new Car("1"), new Car("1"), new Car("2"));

        // when & then
        assertThatThrownBy(() -> new RacingGame(overlappingNamesCars, gameRound))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_게임_단독_우승자() {
        // given
        int randomNumber = 4;
        int gameRound = 5;
        RacingGame racingGame = new RacingGame(cars, gameRound);

        // when
        IntStream.range(0, 5).forEach(i -> {
            cars.get(0).forward(randomNumber);
        });

        List<Car> winners = racingGame.getWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.getFirst().getName()).isEqualTo("1");
        assertThat(winners.getFirst().getDistance()).isEqualTo(5);
    }

    @Test
    void 레이싱_게임_공동_우승자() {
        // given
        int randomNumber = 4;
        int gameRound = 5;

        RacingGame racingGame = new RacingGame(cars, gameRound);

        // when
        IntStream.range(0, 5).forEach(i -> {
            cars.get(0).forward(randomNumber);
            cars.get(1).forward(randomNumber);
        });

        List<Car> winners = racingGame.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners.getFirst().getName()).isEqualTo("1");
        assertThat(winners.getFirst().getDistance()).isEqualTo(5);
        assertThat(winners.getLast().getName()).isEqualTo("2");
        assertThat(winners.getLast().getDistance()).isEqualTo(5);
    }
}