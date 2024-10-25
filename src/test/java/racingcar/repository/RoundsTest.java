package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Round;

class RoundsTest {
    private Car pobiCar;
    private Car woniCar;
    private Car junCar;
    private List<Car> cars;
    private Rounds rounds;

    @BeforeEach
    void setUp() {
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
        junCar = new Car("jun");
        cars = new ArrayList<>(Arrays.asList(pobiCar, woniCar, junCar));
        rounds = new Rounds();
    }

    @Test
    @DisplayName("Round 저장을 정상적으로 한다")
    void saveTest() {
        rounds.save(new Round(cars));
        assertThat(rounds.findAllRounds()).hasSize(1);
    }

    @Test
    @DisplayName("여러 Round가 존재 한 상태에서 마지막 라운드에서 우승자를 잘 선택한다")
    void pickWinnerTest() {
        rounds.save(new Round(cars));
        addSecondRound();
        assertThat(rounds.findAllRounds()).hasSize(2);
        List<Car> winnerCars = rounds.findWinnerCars();
        assertThat(winnerCars).hasSize(2);
        assertThat(winnerCars.get(0).getName()).isEqualTo(pobiCar.getName());
        assertThat(winnerCars.get(1).getName()).isEqualTo(woniCar.getName());
    }

    private void addSecondRound() {
        pobiCar.move();
        woniCar.move();
        List<Car> secondCarStatus = new ArrayList<>(Arrays.asList(pobiCar, woniCar, junCar));
        rounds.save(new Round(secondCarStatus));
    }

}
