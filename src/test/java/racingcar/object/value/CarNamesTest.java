package racingcar.object.value;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 지정되지_않은_참가자명에대해_예외발생() {
        assertThatThrownBy(() -> new CarNames(null))
                .isInstanceOf(COMMON_EXCEPTION);
    }

    @Test
    void 적절하지_않은_참가자수에대해_예외발생() {
        assertThatThrownBy(() -> {
            new CarNames(List.of(
                    new CarName("1"),
                    new CarName("2"),
                    new CarName("3"),
                    new CarName("4"),
                    new CarName("5"),
                    new CarName("6"),
                    new CarName("7"),
                    new CarName("8"),
                    new CarName("9"),
                    new CarName("10")));
        }).isInstanceOf(COMMON_EXCEPTION);
    }

}