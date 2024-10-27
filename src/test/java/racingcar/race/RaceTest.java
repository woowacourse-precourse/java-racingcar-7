package racingcar.race;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void create_race_instance_should_be_pass() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vehicles.add(new Car("car_" + i));
        }
        int round = 9;
        // when
        // then
        Assertions.assertDoesNotThrow(() -> new Race(vehicles, round));
    }

    @Test
    void create_race_when_1_cars_should_be_fail() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("car_1"));
        int round = 10;
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Race(vehicles, round));
        Assertions.assertEquals("자동차는 최소 2대가 필요합니다.", ex.getMessage());
    }

    @Test
    void create_race_when_11_cars_should_be_fail() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            vehicles.add(new Car("car" + i));
        }
        int round = 1;
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Race(vehicles, round));
        Assertions.assertEquals("자동차는 최대 10대까지 생성할 수 있습니다.", ex.getMessage());
    }

    @Test
    void create_race_when_0_round_should_be_fail() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vehicles.add(new Car("car_" + i));
        }
        int round = 0;
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Race(vehicles, round));
        Assertions.assertEquals("라운드는 1 라운드 이상부터 가능합니다.", ex.getMessage());
    }

    @Test
    void create_race_when_21_round_should_be_fail() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vehicles.add(new Car("car_" + i));
        }
        int round = 21;
        // when
        // then
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Race(vehicles, round));
        Assertions.assertEquals("라운드는 최대 20 라운드까지만 진행할 수 있습니다.", ex.getMessage());
    }

    @Test
    void start_should_be_pass() {
        // given
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vehicles.add(new Car("car_" + i));
        }
        int round = 10;
        Race race = new Race(vehicles, round);
        // when
        // then
        Assertions.assertDoesNotThrow(race::start);
    }
}
