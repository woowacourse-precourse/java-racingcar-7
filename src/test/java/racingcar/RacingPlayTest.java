package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.RacingUtil;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingPlayTest {

    @DisplayName("자동차 리스트를 반환한다")
    @Test
    void getValidCarList() {
        String input = "pobi,crong,honux";
        List<Car> expect = new ArrayList<>();
        expect.add(new Car("pobi"));
        expect.add(new Car("crong"));
        expect.add(new Car("honux"));

        List<Car> carList = RacingUtil.getCarList(input);

        assertThat(expect.retainAll(carList)).isTrue();
    }

    @DisplayName("자동차가 전진하는지 확인한다")
    @Test
    void validMoveCar() {
        List<Car> expect = new ArrayList<>();
        expect.add(new Car("pobi"));
        expect.add(new Car("crong"));
        boolean test = false;

        for (int i = 0; i < 30; i++) {
            RacingUtil.setMoveOrStop(expect);
            if (expect.get(0).getPosition() > 0 || expect.get(1).getPosition() > 0) {
                test = true;
                break;
            }
        }

        assertThat(test).isTrue();
    }

    @DisplayName("우승자가 1명일 경우")
    @Test
    void OneWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.get(0).forward();

        List<String> winners = RacingUtil.findWinner(carList);

        assertThat(winners.get(0).equals("pobi")).isTrue();
    }

    @DisplayName("우승자가 여러명일 경우")
    @Test
    void multipleWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("honux"));
        carList.add(new Car("java"));
        carList.get(0).forward();
        carList.get(2).forward();

        List<String> winners = RacingUtil.findWinner(carList);

        assertThat(winners.get(0).equals("pobi") && winners.get(1).equals("honux")).isTrue();
    }
}
