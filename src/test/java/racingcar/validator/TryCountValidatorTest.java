package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryCountValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("자동차 이름이 빈 값이면 예외가 발생한다.")
    void checkEmptyCarName(int tryCount){
        //Arrange
        TryCountValidator tryCountValidator = new TryCountValidator();

        //Act
        assertThatThrownBy(()-> {
            tryCountValidator.validTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
