package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationCheckTest {

    ValidationCheck validationCheck = new ValidationCheck();
    @ParameterizedTest
    @NullSource
    void isNullOrEmptyCarNameTest(String carName){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateCarName(carName);
        });

        assertThat(e.getMessage()).isEqualTo("입력값이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings="abcedf,abc")
    void hasMoreThanFiveCharactersTest(String carName){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateCarName(carName);
        });
        assertThat(e.getMessage()).isEqualTo("이름이 다섯글자가 넘거나 이름에 허용되지 않는 특수문자가 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings="abc1,abc1,efg")
    void hasDuplicateNames(String carName){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateCarName(carName);
        });
        assertThat(e.getMessage()).isEqualTo("중복된 자동차 이름이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings="abc1,abc2,efg,")
    void EndsWithCommaTest(String carName){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateCarName(carName);
        });
        assertThat(e.getMessage()).isEqualTo("구분자 뒤에 자동차 이름을 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings="a")
    void hasNumberFormatExceptionTest(String numberOfTrial){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateNumberOfTrial(numberOfTrial);
        });
        assertThat(e.getMessage()).isEqualTo("시도 횟수가 올바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings="-1")
    void isNegativeNumber(String numberOfTrial){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            validationCheck.validateNumberOfTrial(numberOfTrial);
        });
        assertThat(e.getMessage()).isEqualTo("최소 한 번의 시도를 해야합니다.");
    }
}