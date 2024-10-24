package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingGameServiceTest {
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        GameSettings gameSettings = new GameSettings(0, 9, 4);
        racingGameService = new RacingGameService(gameSettings);
    }

    @Test
    void 무작위_값을_구하고_해당_값이_4_이상이면_자동차를_움직인다() {
        Car car = Car.of("pobi");
        racingGameService.race(car);
    }

    @Test
    void 이동_거리가_가장_높은_자동차가_우승자다() {
        Car car1 = Car.of("pobi");
        car1.move();
        car1.move();
        Car car2 = Car.of("jun");
        car2.move();
        List<Car> cars = List.of(car1, car2);
        List<String> winners = racingGameService.getWinners(cars);
        assertThat(List.of("pobi")).isEqualTo(winners);
    }

    @Test
    void 동일한_이동_거리가_있으면_우승자는_중복될_수_있다() {
        Car car1 = Car.of("pobi");
        car1.move();
        Car car2 = Car.of("jun");
        car2.move();
        List<Car> cars = List.of(car1, car2);
        List<String> winners = racingGameService.getWinners(cars);
        assertThat(List.of("pobi", "jun")).isEqualTo(winners);
    }

    @Test
    void 자동차를_이동하지_않아도_우승자는_한_대_이상_존재한다() {
        Car car1 = Car.of("pobi");
        Car car2 = Car.of("jun");
        List<Car> cars = List.of(car1, car2);
        List<String> winners = racingGameService.getWinners(cars);
        assertThat(List.of("pobi", "jun")).isEqualTo(winners);
    }
}