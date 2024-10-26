package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("자동차 리스트 유효성 테스트")
class CarsValidatorTest {
    @Test
    @DisplayName("중복되지 않는 이름 입력")
    void notDuplicateName() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));

        assertDoesNotThrow(() -> {
           CarsValidator.validateCars(cars);
        });
    } // notDuplicateName

    @Test
    @DisplayName("중복되는 이름 입력 예외")
    void duplicateException() {
        List<Car> cars = List.of(new Car("pobi"), new Car("pobi"));

        assertThatThrownBy(() -> {
            CarsValidator.validateCars(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_CANNOT_DUPLICATE);
    } // duplicateException

    @Test
    @DisplayName("5대 이하일 때")
    void maxCarUnits() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"),
                new Car("jjang"), new Car("lee"));

        assertDoesNotThrow(() -> {
            CarsValidator.validateCars(cars);
        });
    } // maxCarUnits

    @Test
    @DisplayName("5대 초과일 때")
    void maxCarUnitsException() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"),
                new Car("jjang"), new Car("lee"), new Car("hi"));

        assertThatThrownBy(() -> {
            CarsValidator.validateCars(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PREFIX + ErrorMessage.MAX_CAR_UNITS_IS_FIVE);
    } // maxCarUnitsException
} // class