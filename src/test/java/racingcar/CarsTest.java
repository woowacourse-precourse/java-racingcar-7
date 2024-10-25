package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 차들이 모두 전진함에 따라 포지션이 1씩 증가한다는 로직을 테스트하라")
    @Test
    void test1() {
        Cars cars = new Cars(List.of(new Car("A"), new Car("B"), new Car("C")));

        List<Integer> positions1 = cars.go(() -> true);
        List<Integer> positions2 = cars.go(() -> true);
        List<Integer> positions3 = cars.go(() -> true);

        assertThat(positions1).isEqualTo(List.of(1, 1, 1));
        assertThat(positions2).isEqualTo(List.of(2, 2, 2));
        assertThat(positions3).isEqualTo(List.of(3, 3, 3));
    }
}
