package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void isNullOrBlank() {
        assertThat(InputValidator.isNullOrBlank(" ")).isEqualTo(true);
        assertThat(InputValidator.isNullOrBlank(null)).isEqualTo(true);
        assertThat(InputValidator.isNullOrBlank("")).isEqualTo(true);
        assertThat(InputValidator.isNullOrBlank("\n")).isEqualTo(true);
        assertThat(InputValidator.isNullOrBlank("\t")).isEqualTo(true);
    }

    @Test
    void isValidFormat() {
        assertThat(InputValidator.isValidFormat("do,rae,mi,fa,sol")).isEqualTo(true);
        assertThat(InputValidator.isValidFormat("do,rae,mi,fa,sollasi")).isEqualTo(false);
        assertThat(InputValidator.isValidFormat("1,2,3,4,5")).isEqualTo(true);
        assertThat(InputValidator.isValidFormat("1,2,3,4,555555")).isEqualTo(false);
        assertThat(InputValidator.isValidFormat("d o,rae,mi,fa,sol")).isEqualTo(false);
        assertThat(InputValidator.isValidFormat("do:rae:mi:fa:sol")).isEqualTo(false);
        assertThat(InputValidator.isValidFormat("350,Y,ray")).isEqualTo(true);
    }

    @Test
    void isValidNumber() {
        assertThat(InputValidator.isValidNumber("1")).isEqualTo(true);
        assertThat(InputValidator.isValidNumber("0")).isEqualTo(false);
        assertThat(InputValidator.isValidNumber("ten")).isEqualTo(false);
        assertThat(InputValidator.isValidNumber("")).isEqualTo(false);
    }
}