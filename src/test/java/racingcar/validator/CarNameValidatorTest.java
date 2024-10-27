package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름이 빈 값이면 예외가 발생한다.")
    void checkEmptyCarName(String name){
        //Arrange
        CarNameValidator carNameValidator = new CarNameValidator();

        //Act
        assertThatThrownBy(()-> {
            carNameValidator.isValidCarName(name);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"yeonjoon", "soojin"})
    @DisplayName("자동차 이름 길이가 5 이하가 아니면 예외가 발생한다.")
    void cannotMakeCar(String name){
        //Arrange
        CarNameValidator carNameValidator = new CarNameValidator();

        //Act
        assertThatThrownBy(()-> {
            carNameValidator.isValidCarName(name);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
