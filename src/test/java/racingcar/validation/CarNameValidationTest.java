package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.message.Message;

class CarNameValidationTest {
    private CarNameValidation carNameValidation;

    @BeforeEach
    void setup() {
        carNameValidation = new CarNameValidation();
    }

    @Test
    void 예외발생_중복_이름_테스트() {
        // Arrange
        List<String> carNames = Arrays.asList("pobi", "woni", "pobi");

        // Act & Assert
        assertThatThrownBy(() -> carNameValidation.isNotDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.duplicateName.getMessage());
    }

    @Test
    void 예외발생_빈_이름_테스트() {
        List<String> carNames = Arrays.asList("pobi", "");

        assertThatThrownBy(() -> carNameValidation.isNotEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.emptyName.getMessage());
    }

    @Test
    void 예외발생_널값_테스트() {
        // Arrange
        List<String> carNames = Arrays.asList("car1", null);

        // Act & Assert
        assertThatThrownBy(() -> carNameValidation.isNotEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.emptyName.getMessage());
    }

    @Test
    void 예외발생_이름이_길때_테스트() {
        List<String> carNames = Arrays.asList("pobi", "woni", "longname");

        assertThatThrownBy(() -> carNameValidation.isNameLengthValid(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.lengthLimit.getMessage());
    }

    @Test
    void 정상작동_모든이름이유효할때_테스트() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        carNameValidation.isNameLengthValid(carNames); // Should not throw
    }
}