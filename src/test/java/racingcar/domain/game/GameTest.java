package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.application.RandomForwardPolicy;
import racingcar.domain.car.Car;
import racingcar.mock.MockDisplay;

class GameTest {

    @Test
    public void 가장많이_움직인_자동차가_우승한다() throws Exception {
        //given
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        Game game = Game.of(cars, new MockDisplay());

        //when
        game.start(50, new RandomForwardPolicy());
        List<Car> winners = game.getWinners();
        int highestPosition = winners.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        //then
        assertThat(winners).map(Car::getPosition)
            .allMatch(position -> position == highestPosition);
    }

    @Test
    public void 모두가_똑같이_움직이면_모두가_우승한다() throws Exception {
        //given
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        Game game = Game.of(cars, new MockDisplay());

        //when
        game.start(50, () -> true);
        List<Car> winners = game.getWinners();

        //then
        assertThat(winners).isEqualTo(cars);
        assertThat(winners).map(Car::getPosition)
            .allMatch(position -> position == 50);
    }

    @Test
    public void 단_하나의_자동차라도_움직이지_않으면_모두가_우승한다() throws Exception {
        //given
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        Game game = Game.of(cars, new MockDisplay());

        //when
        game.start(50, () -> false);
        List<Car> winners = game.getWinners();

        //then
        assertThat(winners).isEqualTo(cars);
        assertThat(winners).map(Car::getPosition)
            .allMatch(position -> position == 0);
    }
}