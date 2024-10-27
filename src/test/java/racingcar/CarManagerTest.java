package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    @Test
    void 사용자의_입력으로부터_자동차_리스트_생성() {
        CarManager carManager = new CarManager();
        List<Car> car = carManager.createCarsFromInput("abc,bcd,bhc");
        assertThat(car.size()).isEqualTo(3);

    }

    @Test
    void 이름은_2개부터_1000개까지_가능() {
        CarManager carManager = new CarManager();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    carManager.createCarsFromInput("abc");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 개수는 최소 2개부터 최대 1,000개까지 가능합니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    carManager.createCarsFromInput(String.join(",", Collections.nCopies(1001, "a")));
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 개수는 최소 2개부터 최대 1,000개까지 가능합니다.")
        );
    }

    @Test
    void 중복된_이름은_허용하지_않는다() {
        CarManager carManager = new CarManager();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    carManager.createCarsFromInput("bhc,bbq,ddangddang,bhc");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 이름은 허용하지 않습니다. 중복 이름 : bhc")
        );
    }

    @Test
    void 거리를_가장_많이_이동한_자동차를_찾는다() {
        CarManager carManager = new CarManager();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("first");
        setDistance(car1,5);

        Car car2 = new Car("two");
        setDistance(car2,2);

        Car car3 = new Car("third");
        setDistance(car3,15);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> actual = carManager.findWinner(cars);
        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0)).isEqualTo(car3);
    }

    @Test
    void 공동_우승() {
        CarManager carManager = new CarManager();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("first");
        setDistance(car1,5);

        Car car2 = new Car("two");
        setDistance(car2,15);

        Car car3 = new Car("third");
        setDistance(car3,15);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> actual = carManager.findWinner(cars);
        assertThat(actual.size()).isEqualTo(2);
    }

    private void setDistance(Object object,Object distance) {
        try {
            Field field = object.getClass().getDeclaredField("distance");
            field.setAccessible(true);
            field.set(object,distance);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
