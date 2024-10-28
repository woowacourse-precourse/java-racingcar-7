package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.random.FixedNumberGenerator;
import racingcar.model.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

class GameTest {

    Game game;

    @Test
    void 숫자가_3_이하면_움직이지_않는다() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("woody", 0));
        game = new Game(cars, new Referee(), new FixedNumberGenerator(3));
        int expected = 0;

        //when
        game.playOneRound();

        //then
        Assertions.assertThat(cars.get(0).getForwardLevel()).isEqualTo(expected);
    }

    @Test
    void 숫자가_4_이상이면_전진한다() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("woody", 0));
        game = new Game(cars, new Referee(), new FixedNumberGenerator(4));
        int expected = 1;

        //when
        game.playOneRound();

        //then
        Assertions.assertThat(cars.get(0).getForwardLevel()).isEqualTo(expected);
    }

    @Test
    void 우승자_찾기() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("woody", 1));
        cars.add(new Car("fobi", 3));
        game = new Game(cars, new Referee(), new RandomNumberGenerator());
        String expected = "fobi";

        //when
        Winners winners = game.getWinners();

        //then
        Assertions.assertThat(winners.getWinnerNames().get(0)).isEqualTo(expected);
    }

}