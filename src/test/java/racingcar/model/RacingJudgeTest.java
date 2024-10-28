package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingJudgeTest {

    private final RacingJudge judge = new RacingJudge();
    private static final RacingGame racingGame = new RacingGame();
    private static final String names = "pobi,woni,jun";
    private static final Generator generator = new Generator();

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
        List<RacingRecord> records = generator.generateRecordsFrom(names);
        //when
        racingGame.racing(List.of(0, 4, 4), records);
        racingGame.racing(List.of(0, 2, 4), records);
        racingGame.racing(List.of(0, 4, 4), records);
        String winner = judge.decideWinnerBy(records);
        //then
        assertThat(winner).isEqualTo("jun");
    }

    @DisplayName("공동_우승자_판별_테스트")
    @Test
    public void decideWinnersTest() {
        //given
        List<RacingRecord> records = generator.generateRecordsFrom(names);
        //when
        racingGame.racing(List.of(4, 4, 4), records);
        racingGame.racing(List.of(4, 4, 4), records);
        racingGame.racing(List.of(4, 4, 4), records);
        String winners = judge.decideWinnerBy(records);
        //then
        assertThat(winners).isEqualTo("pobi, woni, jun");
    }
}