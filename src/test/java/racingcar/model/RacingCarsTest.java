package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    // TODO: race 테스트 작성하기. Random 값에 대한 구조 변경이 필요함.

    @DisplayName("자동차 이름으로 자동차들을 생성할 수 있다.")
    @Test
    void createCars() {
        // given
        List<String> names = List.of("a", "b", "c");

        // when
        RacingCars racingCars = RacingCars.of(names);

        // then
        List<RacingCar> cars = racingCars.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting("name")
                .containsExactlyInAnyOrder("a", "b", "c");
    }

    @DisplayName("중복된 이름을 가진 자동차가 있으면 예외가 발생한다.")
    @Test
    void createCarsWithDuplicateName() {
        // given
        List<String> names = List.of("a", "b", "a");

        // when
        assertThatThrownBy(() -> RacingCars.of(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("가장 먼 위치에 있는 자동차가 우승한다.")
    @Test
    void getWinners() {
        // given
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("car1", 1),
                new RacingCar("car2", 0),
                new RacingCar("car3", 1)
        ));

        // when
        List<RacingCar> winners = racingCars.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("car1", 1),
                        tuple("car3", 1)
                );
    }

}
