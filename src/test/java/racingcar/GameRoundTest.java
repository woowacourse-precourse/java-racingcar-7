package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.GameRound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GameRoundTest {

    @Test
    void 시행_횟수가_1보다_작을_때(){
        //given
        int count = -1;

        //when
        Throwable result = catchThrowable(() -> {
            new GameRound(count);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

}
