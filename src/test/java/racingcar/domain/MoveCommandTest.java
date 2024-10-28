package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoveCommandTest {

    @Test
    public void 이동_명령시_명령을_실행한다() {
        MoveCommand move = MoveCommand.MOVE;
        assertThat(move.execute(false, (flag) -> !flag)).isTrue();
    }

    @Test
    public void 정지_명령시_명령을_실행하지않는다() {
        MoveCommand move = MoveCommand.STOP;
        assertThat(move.execute(false, (flag) -> !flag)).isFalse();
    }
}
