package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 차들이 모두 전진함에 따라 포지션이 1씩 증가한다는 로직을 테스트하라")
    @Test
    void test1() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        cars.move(() -> true);
        cars.move(() -> true);
        cars.move(() -> true);

        Position three = PositionFixture.position(3);
        assertThat(cars.getPositions()).isEqualTo(List.of(three, three, three));
    }

    @DisplayName("n대의 차들이 모두 정지함에 따라 포지션이 그대로인 로직을 테스트하라")
    @Test
    void test2() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        cars.move(() -> true);
        cars.move(() -> true);
        cars.move(() -> true);

        Position three = PositionFixture.position(3);
        assertThat(cars.getPositions()).isEqualTo(List.of(three, three, three));
    }

    @DisplayName("n대의 차들이 2번 정지, 1번 전진에 따라 포지션이 바뀌는 로직을 테스트하라")
    @Test
    void test3() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        cars.move(() -> false);
        cars.move(() -> false);

        cars.move(() -> true);

        Position one = PositionFixture.position(1);
        assertThat(cars.getPositions()).isEqualTo(List.of(one, one, one));
    }

    @DisplayName("n대의 차들이 1번 정지, 2번 전진에 따라 포지션이 바뀌는 로직을 테스트하라")
    @Test
    void test4() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        cars.move(() -> false);

        cars.move(() -> true);
        cars.move(() -> true);

        Position two = PositionFixture.position(2);
        assertThat(cars.getPositions()).isEqualTo(List.of(two, two, two));
    }
}
