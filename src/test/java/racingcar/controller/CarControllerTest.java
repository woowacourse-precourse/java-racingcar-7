package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 생성 테스트")
class CarControllerTest {
    private CarController carController = new CarController();

    @Test
    @DisplayName("쉼표를 기준으로 자동차 이름을 분리한다")
    void splitCarNames() {
        assertThat(carController.splitCarNames("pobi,woni,jun")).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("단일 자동차 객체를 생성한다")
    void createSingleCar() {
        assertThat(carController.createSingleCar("pobi")).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("모든 자동차 객체를 생성한다")
    void createAllCars() {
        assertThat(carController.createAllCars(List.of("pobi", "woni", "jun")).size()).isEqualTo(3);
    }
}