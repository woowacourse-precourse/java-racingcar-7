package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

public class ValidationTest {

    @Test
    void 공백_문자열_입력_테스트() {
        assertTrue(Validator.isEmptyInput(""));
        assertTrue(Validator.isEmptyInput("   "));
    }

    @Test
    void 자동차_이름_공백_유효성_테스트() {
        List<String> carNames = List.of("domi", " ", "koni");

        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarName(carNames));
    }

    @Test
    void 자동차_이름_특수문자_유효성_테스트() {
        List<String> carNames = List.of("domi", "p@ni", "koni");

        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarName(carNames));
    }

    @Test
    void 자동차_이름_길이_테스트() {
        List<String> carNames = List.of("domi", "phonny", "koni");

        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarName(carNames));
    }

}
