package racingcar;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private List<Car> cars;
    private int trial = 3;
    private Race race;

    @BeforeEach
    void 테스트를_위한_자동차_객체와_레이스_객체_초기화() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        cars = new ArrayList<>(List.of(pobi, woni, jun));

        race = new Race(cars, trial);
    }

    @Test
    @DisplayName("레이스를 통해 이동 거리가 가장 큰 자동차의 이름을 출력한다.")
    void 우승자_판별() {
        List<Car> carsInRacing = race.getCars();

        assertRandomNumberInRangeTest(() -> {
            Car pobi = carsInRacing.stream()
                    .filter(car -> car.getName() == "pobi")
                    .findFirst()
                    .get();

            pobi.drive();

            List<Car> winners = race.getWinner();

            String winnersName = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));

            assertThat(winnersName).isEqualTo(pobi.getName());
        }, 4, 9);
    }

    @Test
    @DisplayName("여러 명의 우승자가 존재하는 경우 해당하는 모든 자동차의 이름을 출력한다.")
    void 여러_명의_우승자_판별() {
        List<Car> carsInRacing = race.getCars();

        assertRandomNumberInRangeTest(() -> {
            Car pobi = carsInRacing.stream()
                    .filter(car -> car.getName() == "pobi")
                    .findFirst()
                    .get();

            Car jun = carsInRacing.stream()
                    .filter(car -> car.getName() == "jun")
                    .findFirst()
                    .get();

            pobi.drive();
            jun.drive();

            List<Car> winners = race.getWinner();

            String winnersName = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));

            assertThat(winnersName).isEqualTo(pobi.getName() + ", " + jun.getName());
        }, 4, 9);
    }
}
