package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {
    Validation validation = new Validation();

    @Nested
    @DisplayName("자동차 이름 밸리디에이션 테스트")
    class TestCarNameValidation {

        @Test
        @DisplayName("자동차 이름 검증: 수가 9개 이상이면 예외 발생")
        public void testCarNameValidation_TooManyCars() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateCarName(new String[]{"car1", "car2", "car3", "car4", "car5", "car6", "car7", "car8", "car9"});
            });
        }

        @Test
        @DisplayName("자동차 이름 검증: 1개 이하이면 예외 발생")
        public void testCarNameValidation_TooFewCars() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateCarName(new String[]{"car1"});
            });
        }

        @Test
        @DisplayName("자동차 이름 검증: 이름이 2자 이하이면 예외 발생")
        public void testCarNameValidation_TooShortName() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateCarName(new String[]{"c", "def"});
            });
        }

        @Test
        @DisplayName("자동차 이름 검증: 이름이 3~5자 이면 예외를 발생시키지 않음")
        public void testCarNameValidation_values() {
            assertDoesNotThrow(() -> {
                validation.validateCarName(new String[]{"Tri", "Quad", "Penta"});
            }, "이동횟수가 중간값 10일 때 예외가 발생하지 않아야 합니다.");
        }

        @Test
        @DisplayName("자동차 이름 검증: 이름이 6자 이상이면 예외 발생")
        public void testCarNameValidation_TooLongName() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateCarName(new String[]{"Hexaaa", "abe"});
            });
        }

        @Test
        @DisplayName("자동차 이름 검증: 이름이 알파벳이 아니면 예외 발생")
        public void testCarNameValidation_NonAlphabetic() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateCarName(new String[]{"1234", "cde"});
            });
        }
    }


    @Test
    @DisplayName("자동차 이름 중복 확인 테스트")
    public void testCarNameDuplication() {

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("testCar"));

        // 중복된 자동차 이름이 있는 경우 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.checkDuplicateCar(cars, "testCar");
        }, "자동차 이름은 중복될 수 없습니다.");
    }

    @Nested
    @DisplayName("이동횟수 입력범위 테스트")
    class TestMaxTurn {

        @Test
        @DisplayName("이동횟수 검증: 숫자가 아닌 입력일 때 예외 발생")
        public void testMaxTurn_NotNumber() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateMaxTurn("twenty");
            }, "이동횟수는 숫자만 입력 가능합니다.");
        }

        @Test
        @DisplayName("이동횟수 검증: 최소값보다 적을 때 예외 발생")
        public void testMaxTurn_TooLow() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateMaxTurn("0");
            }, "이동횟수는 최소 1 이상입니다.");
        }

        @Test
        @DisplayName("이동횟수 검증: 최소값일 때")
        public void testMaxTurn_Minimum() {
            assertDoesNotThrow(() -> {
                validation.validateMaxTurn("1");
            }, "이동횟수가 최소값 1일 때 예외가 발생하지 않아야 합니다.");
        }

        @Test
        @DisplayName("이동횟수 검증: 중간값일 때")
        public void testMaxTurn_MiddleValue() {
            assertDoesNotThrow(() -> {
                validation.validateMaxTurn("10");
            }, "이동횟수가 중간값 10일 때 예외가 발생하지 않아야 합니다.");
        }

        @Test
        @DisplayName("이동횟수 검증: 최대값일 때")
        public void testMaxTurn_Maximum() {
            assertDoesNotThrow(() -> {
                validation.validateMaxTurn("20");
            }, "이동횟수가 최대값 20일 때 예외가 발생하지 않아야 합니다.");
        }

        @Test
        @DisplayName("이동횟수 검증: 최대값을 초과할 때 예외 발생")
        public void testMaxTurn_TooHigh() {
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateMaxTurn("21");
            }, "이동횟수는 최대 20 이하입니다.");
        }
    }
}

