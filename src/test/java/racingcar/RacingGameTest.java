package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {
    Validation validation = new Validation();
    @Test
    @DisplayName("자동차 이름 밸리디에이션 테스트")
    public void testCarNameValidation() {


        // 자동차 수가 9개 이상일 때 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"car1", "car2", "car3", "car4", "car5", "car6", "car7", "car8", "car9"});
        }, "자동차 이름은 최대 8개까지 입력 가능합니다.");

        // 자동차 수가 1개 이하일 때 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"car1"});
        },"자동차 이름은 최소 1개 이상 입력 가능합니다.");

        // 자동차 이름이 2자 이하일 때 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"c", "def"});
        }, "자동차 이름은 2자 이상으로 입력해야합니다.");

        // 자동차 이름이 6자 이상일 때 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"carnameiswaytoolong", "abe"});
        }, "자동차 이름은 5자 이하로 입력해야입니다.");

        // 자동차 이름이 알파벳이 아닌 경우 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"1234"});
        }, "자동차 이름은 알파벳 대소문자만 가능합니다.");


    }

    @Test
    @DisplayName("자동차 이름 검증: 수가 9개 이상이면 예외 발생")
    public void testCarNameValidation_TooManyCars() {
        RacingGame game = new RacingGame();
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"car1", "car2", "car3", "car4", "car5", "car6", "car7", "car8", "car9"});
        });
    }

    @Test
    @DisplayName("자동차 이름 검증: 1개 이하이면 예외 발생")
    public void testCarNameValidation_TooFewCars() {
        RacingGame game = new RacingGame();
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"car1"});
        });
    }

    @Test
    @DisplayName("자동차 이름 검증: 이름이 2자 이하이면 예외 발생")
    public void testCarNameValidation_TooShortName() {
        RacingGame game = new RacingGame();
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"c", "def"});
        });
    }

    @Test
    @DisplayName("자동차 이름 검증: 이름이 6자 이상이면 예외 발생")
    public void testCarNameValidation_TooLongName() {
        RacingGame game = new RacingGame();
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"carnameiswaytoolong", "abe"});
        });
    }

    @Test
    @DisplayName("자동차 이름 검증: 이름이 알파벳이 아니면 예외 발생")
    public void testCarNameValidation_NonAlphabetic() {
        RacingGame game = new RacingGame();
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateCarName(new String[]{"1234", "cde"});
        });
    }

    @Test
    @DisplayName("자동차 이름 중복 확인 테스트")
    public void testCarNameDuplication() {

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("testCar"));

        // 중복된 자동차 이름이 있는 경우 오류발생
        assertThrows(IllegalArgumentException.class, () -> {
            validation.checkDuplicateCar(cars,"testCar");
        }, "자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("이동횟수 입력범위 테스트")
    public void testMaxTurnValidation() {
        RacingGame game = new RacingGame();

        // 이동횟수가 숫자가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateMaxTurn("twenty");
        }, "이동횟수는 숫자만 입력 가능합니다.");

        //이동횟수가 1보다 적을 때
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateMaxTurn("0");
        }, "이동횟수는 최소 1 이상입니다.");


        // 범위 내 태스트
        assertDoesNotThrow(() -> {
            validation.validateMaxTurn("1");
        }, "이동횟수가 최소값 1일 때 예외가 발생하지 않아야 합니다.");

        assertDoesNotThrow(() -> {
            validation.validateMaxTurn("10");
        }, "이동횟수가 중간값 10일 때 예외가 발생하지 않아야 합니다.");

        assertDoesNotThrow(() -> {
            validation.validateMaxTurn("20");
        }, "이동횟수가 최대값 20일 때 예외가 발생하지 않아야 합니다.");


        //이동횟수가 20보다 클 때
        assertThrows(IllegalArgumentException.class, () -> {
            validation.validateMaxTurn("21");
        }, "이동횟수는 최대 20 이하입니다.");

    }
}


//* 적절한 자동차 이름 확인
//  * ',' 갯수가 8개 이상이면 **오류발생**
//        * 생성자
//  * 2자~5자 사이의 길이가 아니면 **오류발생**
//        * 알파벳 대소문자로만 이루어져있지 않으면 **오류발생**
//        * 중복되는 이름이 있으면 **오류발생**
//        * 객체 생성
//  * ','로 구분되는 문자열 숫자만큼 자동차 인스턴스를 생성하는지 **확인**
//        * 이동 횟수
//  * 입력값이 숫자가 아니면 **오류발생**
//        * 이동 횟수가 1~20 범위를 넘어가면 **오류발생**
//        * 게임 실행
