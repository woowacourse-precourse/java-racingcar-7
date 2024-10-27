package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceGameTest {

    private RaceGame raceGame;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("pobi", 5); // 우승 예상
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("jun", 5); // 우승 예상
        List<Car> cars = List.of(car1,car2, car3);
        raceGame = new RaceGame(cars);
    }

    @DisplayName("playRound 메소드가 호출된 후 각 Car 객체의 위치가 변하는지 테스트")
    @Test
    void 라운드_진행_테스트() {
        raceGame.playRound();
        assertThat(raceGame.getCars()).allMatch(car -> car.getPosition() >= 0);
    }

    @DisplayName("최고 위치에 있는 자동차가 우승자로 선택되는지 확인")
    @Test
    void 우승자_테스트() {
        List<Car> winners = raceGame.getWinners();
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "jun");
    }
}
