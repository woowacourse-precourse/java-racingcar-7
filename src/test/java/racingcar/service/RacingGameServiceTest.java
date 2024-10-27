package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {

    private RacingGameService racingGameService;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
        cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("ken"));
    }

    @Test
    void 위치가같을때_우승자_여러명_성공() {
        // given
        cars.forEach(Car::forward);

        // when
        List<String> winners = racingGameService.getWinner(cars);

        // then
        assertThat(winners).containsExactly("pobi", "woni", "ken");
    }

    @Test
    void 위치가다를때_우승자_한명_성공() {
        // given
        cars.get(0).forward();

        // when
        List<String> winners = racingGameService.getWinner(cars);

        // then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 자동차가_하나일때_우승자_한명_성공() {
        // given
        List<Car> singleCar = List.of(new Car("pobi"));

        // cars의 position을 수동으로 설정
        singleCar.get(0).forward();  // pobi: position 1

        // when
        List<String> winners = racingGameService.getWinner(singleCar);

        // then
        assertThat(winners).containsExactly("pobi");
    }

}
