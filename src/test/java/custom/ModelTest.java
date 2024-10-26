package custom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import custom.model.RacingScoreBoard;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ModelTest {
    private final RacingScoreBoard racingScoreBoard = new RacingScoreBoard();

    // 이동 실행 기능 테스트

    @Test
    public void 이동실행기능_점수판생성메소드_테스트() {
        List<String> carNames = Arrays.asList("pobi", "jun", "ann");

        racingScoreBoard.registerCars(carNames);

        assertEquals(3, racingScoreBoard.getRegisteredCarNames().size());
        assertTrue(racingScoreBoard.getRegisteredCarNames().contains("pobi"));
        assertTrue(racingScoreBoard.getRegisteredCarNames().contains("jun"));
        assertTrue(racingScoreBoard.getRegisteredCarNames().contains("ann"));
        assertEquals(0, racingScoreBoard.getScore("pobi"));
        assertEquals(0, racingScoreBoard.getScore("jun"));
        assertEquals(0, racingScoreBoard.getScore("ann"));
    }

    @Test
    public void 이동실행기능_점수상승메소드_테스트() {
        racingScoreBoard.registerCars(Arrays.asList("pobi", "jun"));

        racingScoreBoard.addScore("pobi");
        racingScoreBoard.addScore("pobi");

        assertEquals(2, racingScoreBoard.getScore("pobi"));
    }

    // 우승자 판별 기능 테스트

    @Test
    public void 우승자판별기능_우승자가1명일때_테스트() {
        racingScoreBoard.registerCars(Arrays.asList("pobi", "jun", "ann"));
        racingScoreBoard.addScore("pobi");
        racingScoreBoard.addScore("ann");
        racingScoreBoard.addScore("ann");
        racingScoreBoard.addScore("ann");
        racingScoreBoard.addScore("jun");
        racingScoreBoard.addScore("ann");

        List<String> winners = racingScoreBoard.getWinners();

        assertEquals(1, winners.size());
        assertTrue(winners.contains("ann"));
    }

    @Test
    public void 우승자판별기능_우승자가여러명일때_테스트() {
        racingScoreBoard.registerCars(Arrays.asList("pobi", "jun", "ann"));
        racingScoreBoard.addScore("pobi");
        racingScoreBoard.addScore("pobi");
        racingScoreBoard.addScore("ann");
        racingScoreBoard.addScore("ann");
        racingScoreBoard.addScore("jun");

        List<String> winners = racingScoreBoard.getWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("ann"));
    }
}
