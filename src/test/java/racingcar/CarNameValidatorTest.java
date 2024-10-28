package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.car.exception.CarNameException;
import racingcar.car.validation.CarNameValidator;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameValidatorTest {

    CarNameValidator validator = new CarNameValidator();

    @Test
    void 자동차_이름이_빈값이면_예외() {
        CarNameException exception = assertThrows(CarNameException.class,
                () -> validator.validateCarNames(Collections.singletonList("")));
        assertEquals("자동차 이름은 빈 입력일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_null이면_예외() {
        CarNameException exception = assertThrows(CarNameException.class,
                () -> validator.validateCarNames(Collections.singletonList(null)));
        assertEquals("자동차 이름은 null일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_최대길이를_초과하면_예외() {
        CarNameException exception = assertThrows(CarNameException.class,
                () -> validator.validateCarNames(Collections.singletonList("abcdef")));
        assertEquals("자동차 이름은 5글자를 초과할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_중복되면_예외() {
        CarNameException exception = assertThrows(CarNameException.class,
                () -> validator.validateCarNames(Arrays.asList("pobi", "pobi")));
        assertEquals("자동차 이름은 중복될 수 없습니다. 중복된 자동차 이름 : pobi", exception.getMessage());
    }

    @Test
    void 자동차_이름이_영어알파벳이_아니면_예외() {
        CarNameException exception = assertThrows(CarNameException.class,
                () -> validator.validateCarNames(Collections.singletonList("1234")));
        assertEquals("자동차 이름으로 특수문자, 숫자 또는 한글은 사용할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 유효한_자동차_이름() {
        // 예외가 발생하지 않아야 함
        validator.validateCarNames(Arrays.asList("pobi", "woni"));
    }

}
