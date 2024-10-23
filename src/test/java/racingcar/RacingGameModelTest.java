package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.model.RacingGameModel;

public class RacingGameModelTest {
    private RacingGameModel racingGameModel = new RacingGameModel();

    @Test
    void 자동차_이름_리스트로_자동차_객체_리스트가_반환되어야한다() {
        List<String> carNames = List.of("car1", "car2", "car3");

        List<Car> cars = racingGameModel.generateCarsFromNames(carNames);

        assertThat(cars).hasSize(3);
    }

    @Test
    void 자동차_객체_리스트로_자동차_이름_리스트가_반환되어야한다() {
        List<Car> cars = racingGameModel.generateCarsFromNames(List.of("car1", "car2", "car3"));

        List<String> carNames = racingGameModel.generateNamesFromCars(cars);

        assertThat(carNames).hasSize(3);
    }


    @Test
    void 자동차_경주_게임_우승자_하나일경우_이름_리스트_반환_테스트() {
        List<Car> cars = List.of(
                new Car("car1", 1),
                new Car("car2", 0),
                new Car("car3", 3)
        );

        List<String> carNames = racingGameModel.getWinners(cars);

        assertThat(carNames).hasSize(1);
        assertThat(carNames).contains("car3");
    }

    @Test
    void 자동차_경주_게임_우승자_여러개일경우_이름_리스트_반환_테스트() {
        List<Car> cars = List.of(
                new Car("car1", 2),
                new Car("car2", 0),
                new Car("car3", 2)
        );

        List<String> carNames = racingGameModel.getWinners(cars);

        assertThat(carNames).hasSize(2);
        assertThat(carNames).contains("car1", "car3");
    }
}
