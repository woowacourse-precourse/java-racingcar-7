package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void validateCarName() {
        //given
        List<String> validCarNames = Arrays.asList("pobi","woni","java");

        //when
        //then
        assertThatCode(() -> InputValidator.validateCarName(validCarNames)).doesNotThrowAnyException();
    }

    @Test
    void validateTryCount() {
        //given
        String validTryCount = "5";

        //when
        //then
        assertThatCode(() -> InputValidator.validateTryCount(validTryCount)).doesNotThrowAnyException();
    }
}