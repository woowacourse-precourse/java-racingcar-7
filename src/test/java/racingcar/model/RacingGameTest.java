package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 게임_실행_및_라운드_결과() {
        List<Car> carList = List.of(new Car("pobi"), new Car("crong"));
        Cars cars = new Cars(carList);
        RacingGame game = new RacingGame(cars, 3);
        game.play(() -> {});
        carList.forEach(car -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0));
    }

    @Test
    void 게임_종료후_우승자() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move(5);
        car2.move(5);
        Cars cars = new Cars(List.of(car1, car2));
        RacingGame game = new RacingGame(cars, 1);
        List<String> winners = game.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong");
    }

}
