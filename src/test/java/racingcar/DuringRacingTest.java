package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DuringRacingTest {

    @Test
    void 무작위_값_4_이상_확인(){
        int randomValue = 3;
        Assertions.assertThat(DuringRacing.move(randomValue)).isFalse();
    }

}