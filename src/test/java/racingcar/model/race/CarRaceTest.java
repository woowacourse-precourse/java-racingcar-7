package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.strategy.AlwaysMoveStrategy;
import racingcar.model.race.strategy.MoveStrategy;

@DisplayName("자동차 경주 객체 테스트")
class CarRaceTest {

    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        // 랜덤값은 테스트하기 어렵기 때문에 항상 움직일 수 있는 전략으로 테스트합니다.
        moveStrategy = new AlwaysMoveStrategy();
    }

    @Test
    @DisplayName("한 라운드를 진행하여 자동차의 위치가 업데이트되는지 확인한다.")
    void should_UpdateCarPositionsWhenStartRound() {
        List<String> testCarNames = List.of("pobi", "woni");
        Cars cars = new Cars(testCarNames);
        CarRace carRace = new CarRace(cars, moveStrategy);

        carRace.startRound();

        List<Car> allCars = cars.getCars();
        assertThat(allCars.get(0).getName()).isEqualTo(testCarNames.get(0));
        assertThat(allCars.get(1).getName()).isEqualTo(testCarNames.get(1));
        assertThat(allCars.get(0).getPosition()).isEqualTo(1);
        assertThat(allCars.get(1).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 경주 후 우승 자동차의 이름을 반환한다.")
    void should_ReturnWinnerCarNamesAfterRace() {
        List<String> testCarNames = List.of("pobi", "woni");
        Cars cars = new Cars(testCarNames);
        CarRace carRace = new CarRace(cars, moveStrategy);

        carRace.startRound();

        assertThat(carRace.getWinnerCarNames()).containsExactlyInAnyOrder("pobi", "woni");
    }
}
