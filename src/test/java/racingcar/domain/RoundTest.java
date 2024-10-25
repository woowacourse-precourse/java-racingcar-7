package racingcar.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {
    private Car pobiCar;
    private Car woniCar;
    private Car junCar;
    private Round round;

    @BeforeEach
    void setUp() {
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
        junCar = new Car("jun");
        round = new Round(List.of(pobiCar, woniCar, junCar));
    }

    @Test
    @DisplayName("해당 라운드의 여러 우승자 리스트를 반환한다.")
    void pickWinners() {
        pobiCar.move();
        woniCar.move();
        List<Car> winners = round.pickWinners();
        assertThat(winners).containsOnly(pobiCar, woniCar);
        assertThat(winners.get(0).getPosition()).isEqualTo(1);
        assertThat(winners.get(1).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("해당 라운드의 단일 우승자 리스트를 반환한다.")
    void getWinner() {
        pobiCar.move();
        List<Car> winners = round.pickWinners();
        assertThat(winners).containsOnly(pobiCar);
        assertThat(winners.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("아무도 움직이지 않을 때 우승자 리스트를 반환한다.")
    void getWinnerWhenNoOneMoves() {
        List<Car> winners = round.pickWinners();
        assertThat(winners).containsOnly(pobiCar, woniCar, junCar);
    }
}
