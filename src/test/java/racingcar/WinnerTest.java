package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingService;

import java.util.List;

public class WinnerTest {

    private final RacingService racingService = new RacingService();

    @Test
    @DisplayName("우승자 반환 테스트 - 한명인 경우")
    void getWinnersTest() {
        // given
        Car car1 = new Car("pobi");
        car1.move();
        car1.move();

        Car car2 = new Car("woni");
        car2.move();
        car2.move();
        car2.move();

        Car car3 = new Car("jun"); // 이동 안 함

        List<Car> cars = List.of(car1, car2, car3);

        // when
        List<String> winners = racingService.getWinners(cars);

        // then
        Assertions.assertThat(winners).containsExactly("woni");
    }
    @Test
    @DisplayName("우승자 동점 테스트 - 두명인 경우")
    void testGetWinners_Tied() {
        // given
        Car car1 = new Car("pobi");
        car1.move();
        car1.move();

        Car car2 = new Car("woni");
        car2.move();
        car2.move();

        Car car3 = new Car("jun");
        car3.move();

        List<Car> cars = List.of(car1, car2, car3);

        // when
        List<String> winners = racingService.getWinners(cars);

        // then
        Assertions.assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
