package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차의_이름은_5자_이하여야_한다() {
        assertThatCode(() -> new Car("javaj")).doesNotThrowAnyException();
    }

    @Test
    public void 자동차의_이름은_6자_이상이면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("javaji"));
    }
}
