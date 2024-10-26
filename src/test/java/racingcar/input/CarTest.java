package racingcar.input;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    void 여섯자_이상_예외_테스트() {
        예외_실행("javaji", "이름은 5자 이하로 입력해야 합니다.");
        예외_실행("Yunsu4", "이름은 5자 이하로 입력해야 합니다.");
    }

    @Test
    void 기호가_포함된_경우_예외_테스트() {
        예외_실행("su_4", "이름은 기호를 포함할 수 없습니다.");
        예외_실행("!yun", "이름은 기호를 포함할 수 없습니다.");
        예외_실행("(win)", "이름은 기호를 포함할 수 없습니다.");
    }

    @Test
    void 공백이_포함된_경우_예외_테스트() {
        예외_실행("su 4", "이름은 공백을 포함할 수 없습니다.");
        예외_실행("2 yun", "이름은 공백을 포함할 수 없습니다.");
        예외_실행("wo wa", "이름은 공백을 포함할 수 없습니다.");
    }


    void 예외_실행(String input, String errorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car(input, 0));
        assertEquals(errorMessage, exception.getMessage());
    }

}