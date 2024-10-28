package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationCheckTest {

    ValidationCheck validationCheck = new ValidationCheck();
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmptyCarNameTest(String carName){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validationCheck.validateCarName(carName));
        assertThat(e.getMessage()).isEqualTo("입력값이 없습니다.");
    }

}