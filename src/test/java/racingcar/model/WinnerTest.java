package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    void 우승자_결정_기준인_가장_큰_수_찾기_테스트() {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("kim", 3));
        racingCarList.add(new RacingCar("lee", 2));
        racingCarList.add(new RacingCar("son", 7));
        racingCarList.add(new RacingCar("kane", 5));

        Winner winner = new Winner();
        assertEquals(7, winner.maxPosition(racingCarList));
    }

    @Test
    void 단독_우승자_찾기_테스트() {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("kim", 3));
        racingCarList.add(new RacingCar("lee", 2));
        racingCarList.add(new RacingCar("son", 7));
        racingCarList.add(new RacingCar("kane", 5));

        Winner winner = new Winner();
        String winnerList = winner.getList(racingCarList, 7);
        String winners = "son";

        assertEquals(winners, winnerList);
    }

    @Test
    void 공동_우승자_찾기_테스트() {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("kim", 3));
        racingCarList.add(new RacingCar("lee", 2));
        racingCarList.add(new RacingCar("son", 7));
        racingCarList.add(new RacingCar("kane", 7));

        Winner winner = new Winner();
        String winnerList = winner.getList(racingCarList, 7);
        String winners = "son, kane";

        assertEquals(winners, winnerList);
    }
}
