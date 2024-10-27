package racingcar.model.Error;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Util.Parser;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.model.Error.ErrorMessage.*;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator;
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        carNameValidator = new CarNameValidator(parser);
    }

    @Test
    void 유효한_자동차_이름_입력_테스트() {
        String input = "car1,car2,car3";
        List<String> expected = Arrays.asList("car1", "car2", "car3");

        List<String> result = carNameValidator.validateCarName(input);

        assertEquals(expected, result);
    }

    @Test
    void 빈_입력_값_테스트() {
        String input = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateCarName(input);
        });

        assertEquals(InputMustHaveValue, exception.getMessage());
    }

    @Test
    void 자동차_이름_중복_테스트() {
        String input = "car1,car2,car1";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateCarName(input);
        });

        assertEquals(CarNameMustBeUnique, exception.getMessage());
    }

    @Test
    void 자동차_이름_최대_길이_초과_테스트() {
        String input = "longname,car2,car3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateCarName(input);
        });

        assertEquals(CarNameMaxis5Length, exception.getMessage());
    }

    @Test
    void 허용되지_않은_구분자_테스트() {
        String input = "car1;car2";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateCarName(input);
        });

        assertEquals(NotAllowedDelimiter, exception.getMessage());
    }
}
