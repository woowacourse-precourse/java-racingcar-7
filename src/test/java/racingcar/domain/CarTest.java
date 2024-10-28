package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    public void 자동차의_이름은_5자_이하여야_한다() {
        assertThatCode(() -> new Car("javaj")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"javaji", "", " "})
    public void 자동차이름에_빈값_혹은_6자이상이면_예외가_발생한다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest
    @CsvSource(value = {"MOVE,1", "STOP,0"})
    public void 자동차는_이동하거나_이동하지_않을_수_있다(MoveCommand move, int resultPosition) {
        String name = "test";
        Car car = new Car(name, 0);

        assertThat(car.move(() -> move)).isEqualTo(new Car(name, resultPosition));
    }
}
