package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    
    @Test
    void should_CreateCar_When_NameIsValid() {
        // Arrange & Act
        Car car = new Car("pobi");

        // Assert
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getProgress()).isZero();
    }
    
    @Test
    void should_ThrowException_When_NameIsEmpty() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 비어 있으면 안됩니다.");
    }
    
    @Test
    void should_ThrowException_When_NameIsNull() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 비어 있으면 안됩니다.");
    }
    
    @Test
    void should_ThrowException_When_NameIsTooLong() {
        // Arrange
        String longName = "abcdef"; // 6자

        // Act & Assert
        assertThatThrownBy(() -> new Car(longName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }
    
    
}
