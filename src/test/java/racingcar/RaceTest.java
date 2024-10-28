package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    private OutputView outputView;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        cars = List.of(new Car("car1"), new Car("car2"));
    }

    @Test
    void 경주_결과_출력() {
        int tryCount = 3;
        Race race = new Race(outputView, cars, tryCount);

        race.startRace();

        assertThat(cars).allMatch(car -> car.getPosition() >= 0);
    }

    @Test
    void 우승자_결정_간접_검증() {
        cars.get(0).move(4);  // car1의 위치를 1 증가
        cars.get(1).move(3);  // car2의 위치를 0 증가

        Race race = new Race(outputView, cars, 1);
        race.startRace();

        // car1의 위치가 더 크므로 car1이 우승자여야 합니다.
        Car winner = cars.stream()
                .max((car1, car2) -> Integer.compare(car1.getPosition(), car2.getPosition()))
                .orElseThrow();

        assertThat(winner.getName()).isEqualTo("car1");
    }
}
