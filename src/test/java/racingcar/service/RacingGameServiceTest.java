package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingGameServiceTest {
    private final RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("자동차가 무작위 값에 따라 이동하는지 확인")
    void moveCars_increaseForwardCount() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        racingGameService.moveCars(cars);

        for (Car car : cars) {
            assertThat(car.getForwardCount()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName("최종 우승자 판별 기능 테스트")
    void findWinners() {
        Car car1 = new Car("pobi");
        car1.setForwardCount(5);
        Car car2 = new Car("woni");
        car2.setForwardCount(3);

        List<String> winners = racingGameService.findFinalWinner(List.of(car1, car2));
        assertThat(winners).containsExactly("pobi");
    }
}