package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Cars 객체 테스트")
class CarsTest {
    @ParameterizedTest(name = "{index} : {1}")
    @MethodSource("generateData")
    @DisplayName("자동차 리스트 객체 생성")
    void createCars(List<Car> cars, String message) {
        assertThat(new Cars(cars)).isInstanceOf(Cars.class);
    } // createCars

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi"), new Car("woni")), "중복 없을 때"),
                Arguments.of(List.of(new Car("pobi"), new Car("woni"), new Car("jun"),
                        new Car("jjang"), new Car("lee")), "5대일 때"));
    } // generateData

    @ParameterizedTest(name = "{index} : {2}")
    @MethodSource("generateExceptionData")
    @DisplayName("자동차 리스트 객체 생성 예외")
    void createCarsException(List<Car> cars, String expectedErrorMessage, String message) {
        assertThatThrownBy(() -> {
            new Cars(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + expectedErrorMessage);
    } // createCarsException

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(List.of(new Car("pobi"), new Car("pobi")),
                        ErrorMessage.CAR_NAME_CANNOT_DUPLICATE, "중복 있을 때"),
                Arguments.of(List.of(new Car("pobi"), new Car("woni"), new Car("jun"),
                        new Car("jjang"), new Car("lee"), new Car("hi")),
                        ErrorMessage.MAX_CAR_UNITS_IS_FIVE, "5대초과일 때")
        );
    } // generateExceptionData
} // class