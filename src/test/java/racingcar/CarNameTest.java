package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNameTest {

    @DisplayName("조건에 맞다면 이름이 잘 부여된다.")
    @Test
    void makeName() {
        // Arrange
        String name = "andy";

        //Act
        CarName carName = new CarName(name);

        // Act & Assert
        assertEquals(carName.getName(),name);
    }

    @DisplayName("이름이 5자 이상이면 예외가 발생 한다.")
    @Test
    void checkNameLength() {
        // Arrange
        String name = "stephanie";

        // Act & Assert
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 빈 문자열이면 안 된다.")
    @Test
    void checkNameNotEmpty() {
        //Arrange
        String name = "";

        //Act & Assert
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
