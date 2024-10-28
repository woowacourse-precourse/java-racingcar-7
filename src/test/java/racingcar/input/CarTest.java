package racingcar.input;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"javagi", "Yunsu4"})
    void 여섯자_이상_예외_테스트(String input) {
        예외_실행(input, "이름은 5자 이하로 입력해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({"su_4", "!yun", "(win)"})
    void 기호가_포함된_경우_예외_테스트(String input) {
        예외_실행(input, "이름은 기호를 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({"su 4", "2 yun", "wo wa"})
    void 공백이_포함된_경우_예외_테스트(String input) {
        예외_실행(input, "이름은 공백을 포함할 수 없습니다.");
    }


    void 예외_실행(String input, String errorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Car(input, 0));
        assertEquals(errorMessage, exception.getMessage());
    }

}