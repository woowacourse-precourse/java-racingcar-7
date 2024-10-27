package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRace;


public class CarRaceTest {

    @Test
    @DisplayName("자동차 리스트 초기화 테스트")
    void 자동차_리스트_초기화_테스트(){
        List<Car> cars = Arrays.asList(new Car("woo"), new Car("kim"), new Car("lee"));
        CarRace carRace = new CarRace(cars);

        assertThat(carRace.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차 경주 전진 테스트")
    void 자동차_경주_전진_테스트(){
        List<Car> cars = Arrays.asList(new Car("woo"), new Car("kim"), new Car("lee"));

        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(4);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 찾는 테스트")
    void 우승자_찾기_테스트(){
        List<Car> cars = Arrays.asList(new Car("woo"), new Car("kim"), new Car("lee"));
        CarRace carRace = new CarRace(cars);

        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(4);

        List<String> winners = carRace.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("woo", "lee");
    }
}
