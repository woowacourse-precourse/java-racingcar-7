package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerServiceTest {

    @DisplayName("가장 많이 전진한 사람이 우승자입니다")
    @Test
    void 우승자_선출(){
        // given
        Car car1 = new Car("one");
        Car car2 = new Car("two");
        Cars cars = new Cars();
        cars.addCar(car1);
        cars.addCar(car2);
        car1.moveForward();
        car2.moveForward();
        // when
        List<String> winner = WinnerService.selectWinner();
        // then
        Assertions.assertThat(winner).contains("one");
    }

    @DisplayName("가장 많이 전진한 사람이 여러명이면 공동 우승자입니다")
    @Test
    void 공동_우승자_선출(){
        // given
        // given
        Car car1 = new Car("one");
        Car car2 = new Car("two");
        Car car3 = new Car("three");
        Cars cars = new Cars();
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        car1.moveForward();
        car2.moveForward();
        // when
        List<String> winner = WinnerService.selectWinner();
        // then
        Assertions.assertThat(winner).contains("one","two");
    }
}
