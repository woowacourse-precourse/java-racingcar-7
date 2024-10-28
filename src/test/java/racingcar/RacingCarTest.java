package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCarGame;
import racingcar.util.RacingGameRandomNumber;

public class RacingCarTest {

    private static final int ONE_MOVE = 1;
    private static final int NOT_MOVE = 0;

    @Test
    void 이름이_6자이상이면_에러가_난다() {
        List<String> names = new ArrayList<>(List.of("dahee", "woowacourse"));

        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCarGame(names, new RacingGameRandomNumber());
        });
    }

    @Test
    void 랜덤_숫자가_4이상이면_움직인다() {
        List<String> names = new ArrayList<>(List.of("dahee", "woowa"));
        RacingCarGame racingCarGame = new RacingCarGame(names, new MoveRandomNumber());

        racingCarGame.moveCars();
        Map<String, Integer> result = racingCarGame.getMoveResult();

        for (String carName : result.keySet()) {
            Assertions.assertThat(result.get(carName)).isEqualTo(ONE_MOVE);
        }
    }

    @Test
    void 랜덤_숫자가_3이하이면_움직이지_않는다() {
        List<String> names = new ArrayList<>(List.of("dahee", "woowa"));
        RacingCarGame racingCarGame = new RacingCarGame(names, new NotMoveRandomNumber());

        racingCarGame.moveCars();
        Map<String, Integer> result = racingCarGame.getMoveResult();

        for (String carName : result.keySet()) {
            Assertions.assertThat(result.get(carName)).isEqualTo(NOT_MOVE);
        }
    }

    @Test
    void 이동을_가장_많이한_자동차를_반환한다() {
        List<String> names = new ArrayList<>(List.of("dahee", "woowa"));
        RacingCarGame racingCarGame = new RacingCarGame(names, new RacingGameRandomNumber());

        racingCarGame.moveCars();
        Map<String, Integer> result = racingCarGame.getMoveResult();

        int firstCar = result.get("dahee");
        int secondCar = result.get("woowa");

        List<String> winnerCar = racingCarGame.findMaxMoveCars();

        if (firstCar >= secondCar) {
            Assertions.assertThat(winnerCar.contains("dahee")).isTrue();
        } else {
            Assertions.assertThat(winnerCar.contains("woowa")).isTrue();
        }
    }
}
