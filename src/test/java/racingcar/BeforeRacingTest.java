package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BeforeRacingTest {

    @Test
    void divideCarName() {
        String carNameString = "yoo,jin,kim ";
        List<String> names = BeforeRacing.divideCarName(carNameString);
        Assertions.assertThat(names).containsExactly("yoo", "jin", "kim");
    }

    @Test
    void validateName(){
        String carNameString = "  ";
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BeforeRacing.validateName(carNameString);
        });
    }

    @Test
    void deleteBlank() {
        String carNameString = " y o  o,ji         n,kim ";
        List<String> names = BeforeRacing.divideCarName(carNameString);
        Assertions.assertThat(names).containsExactly("yoo", "jin", "kim");
    }
}