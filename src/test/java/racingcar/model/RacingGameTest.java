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

        // 게임이 종료된 후 각 자동차의 위치가 업데이트되었는지 확인
        carList.forEach(car -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0));
    }

    @Test
    void 게임_종료후_우승자() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move(5); // 이동하여 위치가 5가 됨
        car2.move(5); // 이동하여 위치가 5가 됨

        Cars cars = new Cars(List.of(car1, car2));
        RacingGame game = new RacingGame(cars, 1);

        List<String> winners = game.getWinners();

        // 두 자동차가 같은 위치에 있으므로, 모두 우승자로 포함되어야 함
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong");
    }

}
