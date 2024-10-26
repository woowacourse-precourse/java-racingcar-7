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
        MockDisplay display = new MockDisplay(cars);
        Game game = Game.of(cars, display);

        //when
        game.start(50, new RandomForwardPolicy());

        Integer highestPosition = display.getPositionMap()
            .values()
            .stream()
            .max((o1, o2) -> o1 - o2)
            .orElse(0);

        List<Car> winnersFromProgress = display.getPositionMap()
            .keySet()
            .stream()
            .filter(car -> car.getPosition() == highestPosition)
            .toList();

        List<Car> winners = display.getWinners();

        //then
        assertThat(winners).isEqualTo(winnersFromProgress);
    }

    @Test
    public void 모두가_똑같이_움직이면_모두가_우승한다() throws Exception {
        //given
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        MockDisplay display = new MockDisplay(cars);
        Game game = Game.of(cars, display);

        //when
        game.start(50, () -> true);

        //then
        assertThat(display.getWinners()).isEqualTo(cars);
        assertThat(display.getPositionMap().values())
            .allMatch(position -> position == 50);
    }

    @Test
    public void 단_하나의_자동차라도_움직이지_않으면_모두가_우승한다() throws Exception {
        //given
        List<Car> cars = List.of(new Car("A"), new Car("B"), new Car("C"));
        MockDisplay display = new MockDisplay(cars);
        Game game = Game.of(cars, display);

        //when
        game.start(50, () -> false);

        //then
        assertThat(display.getWinners()).isEqualTo(cars);
        assertThat(display.getPositionMap().values())
            .allMatch(position -> position == 0);
    }


}