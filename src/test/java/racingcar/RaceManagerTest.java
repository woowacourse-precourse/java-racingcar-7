package racingcar;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;

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

    @Test
    void 우승자_가려내기_테스트_우승자가_1명일때() {
        //given
        RaceManager rm = new RaceManager();
        //when
        try {
            Field field = rm.getClass().getDeclaredField("cars");
            field.setAccessible(true);
            Car car1 = new Car();
            Car car2 = new Car();

            car1.nameCar("car1");
            car2.nameCar("car2");
            car1.forward();
            car1.forward();
            car2.forward();

            ArrayList<Car> tempList = new ArrayList<>();
            tempList.add(car1);
            tempList.add(car2);

            field.set(rm, tempList);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> champion = rm.selectChampion();

        //then
        assertThat(champion.size()).isEqualTo(1);
        assertThat(champion.get(0)).isEqualTo("car1");

    }

    @Test
    void 우승자_가려내기_테스트_우승자가_여러명일때() {
        //given
        RaceManager rm = new RaceManager();
        //when
        try {
            Field field = rm.getClass().getDeclaredField("cars");
            field.setAccessible(true);
            Car car1 = new Car();
            Car car2 = new Car();

            car1.nameCar("car1");
            car2.nameCar("car2");
            car1.forward();
            car1.forward();
            car2.forward();
            car2.forward();

            ArrayList<Car> tempList = new ArrayList<>();
            tempList.add(car1);
            tempList.add(car2);

            field.set(rm, tempList);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> champion = rm.selectChampion();

        //then
        assertThat(champion.size()).isEqualTo(2);
        assertThat(champion.get(0)).isEqualTo("car1");
        assertThat(champion.get(1)).isEqualTo("car2");
    }

    @Override
    protected void runMain() {

    }
}
