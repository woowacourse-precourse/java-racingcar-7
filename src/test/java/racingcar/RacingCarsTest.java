package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차들의 상태들이")
public class RacingCarsTest {
    RacingCars racingCars;

    @Test
    @DisplayName("4보다 큰 경우 1칸씩 전진한다")
    public void isPerfectResult() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(1);
        racingCars = new RacingCars(new String[]{"tom", "base", "tree"});
        racingCars.moveRacingCars(list);
        Assertions.assertEquals("tom : -\nbase : -\ntree : \n", racingCars.receiveRacingCarTryResult());
    }

    @Test
    @DisplayName("4보다 큰 경우 1칸씩 전진하여 예상한 우승자가 출력된다")
    public void isExpectedWinner() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(1);
        racingCars = new RacingCars(new String[]{"tom", "base", "tree"});
        racingCars.moveRacingCars(list);
        list.clear();
        list.add(6);
        list.add(8);
        list.add(4);
        racingCars.moveRacingCars(list);
        Assertions.assertEquals("tom, base", racingCars.calculateGameResult());
    }
}
