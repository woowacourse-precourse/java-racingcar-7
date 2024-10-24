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
}
