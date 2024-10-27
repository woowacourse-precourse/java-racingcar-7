package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 생성 테스트")
class CarControllerTest {
    private CarController carController;

    @BeforeEach
    void setUp() {
        this.carController = new CarController();
    }

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

    @Test
    @DisplayName("자동차 최대 숫자 초과")
    void exceedMaxCar() {
        assertThatThrownBy(() -> carController.validateCarNames(List.of("pobi", "woni", "jun", "four", "five", "six")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 최대 숫자 이내")
    void withinMaxCar() {
        assertThatCode(() -> carController.validateCarNames(List.of("pobi", "woni", "jun", "four", "five")))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름 중복")
    void duplicateCarName() {
        assertThatThrownBy(() -> carController.validateCarNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 중복없음")
    void uniqueCarName() {
        assertThatCode(() -> carController.validateCarNames(List.of("pobi", "povi", "pob1")))
                .doesNotThrowAnyException();
    }

}