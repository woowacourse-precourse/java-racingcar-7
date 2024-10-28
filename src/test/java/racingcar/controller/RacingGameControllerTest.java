package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingGameControllerTest {

    RacingGameController controller = new RacingGameController();

    @Test
    @DisplayName("splitCar 메서드는 쉼표로 구분된 자동차 이름 리스트를 Car 객체 리스트로 변환한다")
    void splitCar_ShouldSplitNamesAndCreateCarObjects() {
        List<Car> cars = controller.splitCar("lee,sung,hoon");
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("lee");
    }

    @Test
    @DisplayName("winners 메서드는 최고 점수를 가진 자동차들 이름을 반환한다")
    void winners_ShouldReturnNamesOfCarsWithMaxScore() {
        List<Car> cars = List.of(new Car("lee"), new Car("sung"), new Car("hoon"));
        cars.get(0).move(5);
        cars.get(2).move(5);

        List<String> winners = controller.winners(cars);
        assertThat(winners).containsExactlyInAnyOrder("lee", "hoon");
    }
}
