package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.constant.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;
import static racingcar.util.constant.RegisterCarNumberConstant.REGISTER_CARS_INPUT_MAX_LENGTH;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.exception.EmptyInputException;
import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.exception.carName.InvalidCarNameLengthException;
import racingcar.exception.carName.InvalidCharacterException;
import racingcar.exception.carName.InvalidRegisterCarsInputLengthException;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

class RegisterCarServiceTest {

    DataTransformUtil dataTransformUtil = new DataTransformUtil();
    ValidationUtil validationUtil = new ValidationUtil();
    RegisterCarService registerCarService =
            new RegisterCarService(validationUtil, dataTransformUtil);

    @Nested
    @DisplayName("자동차 등록 메소드 테스트")
    class registerCars {

        @Test
        void 빈_입력값_예외테스트() {
            String input = "";
            assertThrows(
                    EmptyInputException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 입력값_최대_범위_예외테스트() {
            String input = "a".repeat(REGISTER_CARS_INPUT_MAX_LENGTH.getValue() + 1);
            assertThrows(
                    InvalidRegisterCarsInputLengthException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 입력값_최대_범위_테스트_및_자동차_이름_길이_테스트() {
            String input = "a".repeat(REGISTER_CARS_INPUT_MAX_LENGTH.getValue());
            assertThrows(
                    InvalidCarNameLengthException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 입력값_문자_예외테스트() {
            String input = ":asdc";
            assertThrows(
                    InvalidCharacterException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 자동차_이름_최대길이_예외테스트() {
            String input = "abcde,fghijk";
            assertThrows(
                    InvalidCarNameLengthException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 자동차_이름_최대길이_테스트() {
            String input = "abcde,fghij";
            assertThat(registerCarService.registerCars(input)).isInstanceOf(Cars.class);
        }

        @Test
        void 자동차_이름_최소길이_예외테스트() {
            String input = "abcde,,fghij";
            assertThrows(
                    EmptyInputException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 자동차_이름_최소길이_테스트() {
            String input = "abcde,f";
            assertThat(registerCarService.registerCars(input)).isInstanceOf(Cars.class);
        }


        @Test
        void 자동차_이름_중복_예외테스트() {
            String input = "pobi,pobi";
            assertThrows(
                    DuplicateCarNameException.class,
                    () -> registerCarService.registerCars(input)
            );
        }

        @Test
        void 결과_테스트() {
            String input = "pobi,eddy,loopy";
            List<Car> carList = List.of(
                    new Car("pobi", PRIME_CAR_DISTANCE.getValue()),
                    new Car("eddy", PRIME_CAR_DISTANCE.getValue()),
                    new Car("loopy", PRIME_CAR_DISTANCE.getValue())
            );

            assertEquals(registerCarService.registerCars(input), new Cars(carList));
        }
    }
}