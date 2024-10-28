package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RacingCarTest extends NsTest {
    @Test
    public void convertStringToMap_validNames_returnsCorrectMap() {
        String carNames = "car1,car2,car3";

        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("car1", 0);
        expectedMap.put("car2", 0);
        expectedMap.put("car3", 0);

        assertThat(RacingCar.convertStringToMap(carNames)).isEqualTo(expectedMap);
    }

    @Test
    public void convertStringToMap_invalidNameLength_throwsException() {
        String carNames = "car1,car2,longname";

        assertThatThrownBy(() -> RacingCar.convertStringToMap(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    public void race_increasesScoreWhenConditionMet() {
        Map<String, Integer> raceScores = new LinkedHashMap<>();
        raceScores.put("car1", 0);
        raceScores.put("car2", 0);

        RacingCar.race(raceScores);

        assertThat(raceScores.get("car1")).isGreaterThanOrEqualTo(0);
        assertThat(raceScores.get("car2")).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void winner_returnsCorrectWinnerWhenSingleHighScore() {
        Map<String, Integer> raceScores = new LinkedHashMap<>();
        raceScores.put("car1", 3);
        raceScores.put("car2", 2);
        raceScores.put("car3", 1);

        String winner = RacingCar.winner(raceScores);

        assertThat(winner).isEqualTo("car1");
    }

    @Test
    public void winner_returnsMultipleWinnersWhenTie() {
        Map<String, Integer> raceScores = new LinkedHashMap<>();
        raceScores.put("car1", 3);
        raceScores.put("car2", 3);
        raceScores.put("car3", 2);

        String winner = RacingCar.winner(raceScores);

        assertThat(winner).isEqualTo("car1, car2");
    }

    @Override
    protected void runMain() {

    }
}