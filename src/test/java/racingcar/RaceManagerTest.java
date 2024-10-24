package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class RaceManagerTest extends NsTest {

    @Test
    void 이름_입력테스트_올바른입력일때() {
        //given
        String input = "abc, cdf, efg,hij";
        RaceManager rm = new RaceManager();
        ArrayList<Car> cars;

        //when
        rm.setCarName(input);
        cars = rm.getCarList();
        //then
        assertThat(cars.get(0).getCarName()).isEqualTo("abc");
        assertThat(cars.get(1).getCarName()).isEqualTo("cdf");
        assertThat(cars.get(2).getCarName()).isEqualTo("efg");
        assertThat(cars.get(3).getCarName()).isEqualTo("hij");
    }

    @Test
    void 이름_콤마없이_하나만_입력할때() {
        //given
        String input = "abc";
        RaceManager rm = new RaceManager();
        ArrayList<Car> cars;

        //when
        rm.setCarName(input);
        cars = rm.getCarList();

        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.get(0).getCarName()).isEqualTo("abc");
    }

    @Test
    void 이름_입력테스트_5자초과시_예외처리() {
        //given
        String input = "abcdefg, cdf, efg,hij";
        RaceManager rm = new RaceManager();

        assertThatThrownBy(() -> rm.setCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
