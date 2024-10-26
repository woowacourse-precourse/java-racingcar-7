package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
