package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.entity.CarNames;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarNamesFormatValidateTest {

    @ParameterizedTest
    @ValueSource(strings = {"ash,green,hotpink", "ash, green",
            "ash ,green", "ash , green", "\n", "홍길동,두루미와다람쥐", "케서린 한"})
    @DisplayName("이름 입력 검증 테스트 예외 처리")
    void carNamesValidateThrowExceptionTest(String carNameInput) {
        assertThatThrownBy(() -> CarNames.getAfterValidateFormat(carNameInput)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ash", "ash,green"})
    @DisplayName("이름 입력 검증 테스트")
    void carNamesValidateDoesNotThrowTest(String carNameInput) {
        assertDoesNotThrow(() -> CarNames.getAfterValidateFormat(carNameInput));
    }
}
