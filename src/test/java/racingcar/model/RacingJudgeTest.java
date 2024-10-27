package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingJudgeTest {

    private RacingJudge judge = new RacingJudge();
    private final RacingGame racingGame = new RacingGame("pobi,woni,jun");

    @DisplayName("RacingJudge_생성_테스트")
    @Test
    public void newRacingJudge() {
        //given
        //when
        //then
        assertThat(judge).isNotNull();
    }

    @DisplayName("단독_우승자_판별_테스트")
    @Test
    public void decideWinnerTest() {
        //given
        List<RacingRecord> records = racingGame.getRecords();
        //when
        racingGame.racing(List.of(0, 4, 4));
        racingGame.racing(List.of(0, 2, 4));
        racingGame.racing(List.of(0, 4, 4));
        String winner = judge.decideWinnerBy(records);
        //then
        assertThat(winner).isEqualTo("jun");
    }

    @DisplayName("공동_우승자_판별_테스트")
    @Test
    public void decideWinnersTest() {
        //given
        List<RacingRecord> records = racingGame.getRecords();
        //when
        racingGame.racing(List.of(0, 4, 4));
        racingGame.racing(List.of(0, 4, 4));
        racingGame.racing(List.of(0, 4, 4));
        String winners = judge.decideWinnerBy(records);
        //then
        assertThat(winners).isEqualTo("woni,jun");
    }
}