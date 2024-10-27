package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.RaceJudge;
import racingcar.model.RacingCar;

class RaceJudgeTest {

    @Test
    void 거리_길이가_가장_큰_우승자_찾기() {
        ArrayList<RacingCar> racingCars = new ArrayList<>(
                Arrays.asList(new RacingCar("pobi1"), new RacingCar("pobi2")));
        racingCars.get(0).race();
        String[] winner = RaceJudge.determineWinner(racingCars);
        assertThat(winner).isEqualTo(new String[]{"pobi1"});
    }

    @Test
    void 길이가_같을때_공통_우승자_찾기() {
        ArrayList<RacingCar> racingCars = new ArrayList<>(Arrays.asList(new RacingCar("pobi"), new RacingCar("pobi2")));
        racingCars.get(0).race();
        racingCars.get(1).race();
        String[] winners = RaceJudge.determineWinner(racingCars);
        assertThat(winners).isEqualTo(new String[]{"pobi", "pobi2"});
    }

}