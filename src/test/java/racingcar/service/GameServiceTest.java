package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class GameServiceTest {

    @Test
    void get_a_winner() {
        Car car1 = new Car("car1");// 2번 전진
        IntStream.range(0, 2).forEach(i -> car1.go());

        Car car2 = new Car("car2"); // 3번 전진
        IntStream.range(0, 3).forEach(i -> car2.go());

        Car car3 = new Car("car3"); // 4번 전진 <- 우승자
        IntStream.range(0, 4).forEach(i -> car3.go());

        Car car4 = new Car("car4"); // 3번 전진
        IntStream.range(0, 3).forEach(i -> car4.go());

        GameService gameService = new GameService(List.of(car1, car2, car3, car4));
        List<Car> winners = gameService.getWinners();

        assertThat(winners).containsExactly(car3);
    }

    @Test
    void get_winners() {
        Car car1 = new Car("car1");// 3번 전진
        IntStream.range(0, 3).forEach(i -> car1.go());

        Car car2 = new Car("car2"); // 4번 전진 <- 공동 우승자
        IntStream.range(0, 4).forEach(i -> car2.go());

        Car car3 = new Car("car3"); // 4번 전진 <- 공동 우승자
        IntStream.range(0, 4).forEach(i -> car3.go());

        Car car4 = new Car("car4"); // 3번 전진
        IntStream.range(0, 3).forEach(i -> car4.go());

        GameService gameService = new GameService(List.of(car1, car2, car3, car4));
        List<Car> winners = gameService.getWinners();

        assertThat(winners).containsExactly(car2, car3);
    }
}