package racingcar.race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacerTest {
    @Test
    void 레이서_예외_테스트(){
        assertThatThrownBy(()->new Racer("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이서_전진_테스트(){
        Racer racer = new Racer("Test");
        racer.move(4);

        assertThat(racer.getPosition()).isEqualTo(1);
    }
}
