package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BeforeRacingTest {

    @Test
    void divideCarName() {
        String carNameString = "yo o,j in,kim";
        List<String> names = BeforeRacing.divideCarName(carNameString);
        Assertions.assertThat(names).containsExactly("yoo", "jin", "kim");
    }

    @Test
    void validateName(){
        String carNameString = "kokoko";
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BeforeRacing.validateName(carNameString);
        });
    }
}