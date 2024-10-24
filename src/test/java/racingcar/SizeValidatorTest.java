package racingcar;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SizeValidatorTest {

    SizeValidator sizeValidator = new SizeValidator();

    @Test
    @DisplayName("5글자 초과시 IllegalArgumentException 발생")
    public void 글자길이_초과시_에러발생() {
        // given
        List<String> rawCarNames = List.of("sizeOver");

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> sizeValidator.isValid(rawCarNames));
    }

}