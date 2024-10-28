package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class RacingTest {

    @Test
    @DisplayName("자동차 리스트 반환 테스트")
    void testGetCars() {
        // given
        String[] carNames = {"pobi", "woni", "june"};
        Racing racing = new Racing(carNames, 5);

        // when
        List<Car> cars = racing.getCars();

        // then
        Assertions.assertThat(cars).hasSize(3);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("june");
    }
    @Test
    @DisplayName("최대 위치 찾기 테스트")
    void testFindMaxPosition() {
        // given
        Racing racing = new Racing(new String[]{"pobi", "woni"}, 1);
        racing.getCars().get(0).move(); // car1이 1칸 이동
        racing.getCars().get(1).move(); // car2도 1칸 이동

        // when
        int maxPosition = racing.findMaxPosition();

        // then
        Assertions.assertThat(maxPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 이름 반환 테스트")
    void testGetWinnerNames() {
        // given
        Racing racing = new Racing(new String[]{"pobi", "woni"}, 3);
        racing.getCars().get(1).move();
        racing.getCars().get(1).move();

        // when
        int maxPosition = racing.findMaxPosition();
        String winners = racing.getWinnerNames(maxPosition);

        // then
        Assertions.assertThat(winners).isEqualTo("woni");
    }


}