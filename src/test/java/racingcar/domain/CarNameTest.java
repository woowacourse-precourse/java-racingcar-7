package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"BMW", "포르쉐", "car1", "포르쉐99"})
    void 유효한_이름(String validName) {
        assertDoesNotThrow(
                () -> new CarName(validName)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "1포르쉐", "여섯글자이름", "ca r", "특수문자!"})
    void 유효하지_않은_이름(String invalidName) {
        assertThrows(IllegalArgumentException.class,
                () -> new CarName(invalidName)
        );
    }
}