package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.Stream;

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

    static Stream<Arguments> createValidCar() {
        return Stream.of(
                Arguments.of(List.of("pobi", "woni", "jun", "four", "five"), "자동차의 최대 숫자 이내"),
                Arguments.of(List.of("pobi", "povi", "pob1"), "자동차 이름 중복 없음")
        );
    }

    @ParameterizedTest(name = "{1}")
    @MethodSource("createValidCar")
    @DisplayName("자동차 이름이 유효하면 예외가 발생하지 않는다")
    void validCarName(List<String> car, String testCase) {
        assertThatCode(() -> carController.validateCarNames(car))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> createInvalidCar() {
        return Stream.of(
                Arguments.of(List.of("pobi", "woni", "jun", "four", "five", "six"), "자동차의 최대 숫자 초과"),
                Arguments.of(List.of("pobi", "pobi"), "자동차 이름 중복")
        );
    }

    @ParameterizedTest(name = "{1}")
    @MethodSource("createInvalidCar")
    @DisplayName("자동차 이름이 잘못되면 예외가 발생한다")
    void invalidCarName(List<String> car, String testCase) {
        assertThatThrownBy(() -> carController.validateCarNames(car))
                .isInstanceOf(IllegalArgumentException.class);
    }

}