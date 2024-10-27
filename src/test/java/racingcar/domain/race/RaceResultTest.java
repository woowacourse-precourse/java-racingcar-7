package racingcar.domain.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarRegistry;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {
    private RaceResult raceResult;
    private CarRegistry carRegistry;
    private StringBuilder resultBuilder;

    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        Set<Car> cars = new HashSet<>();
        resultBuilder = new StringBuilder();
        cars.add(new Car("pobi", () -> FORWARD));
        cars.add(new Car("woni", () -> STOP));
        carRegistry = new CarRegistry(cars);
        raceResult = new RaceResult(resultBuilder, carRegistry);
    }

    @Test
    @DisplayName("레이스 결과에 새로운 결과를 추가할 수 있다")
    void addRaceResult() {
        // given
        String result = "pobi : ---";

        // when
        raceResult.add(result);

        // then
        assertThat(raceResult.toString()).contains(result);
    }

    @Test
    @DisplayName("우승자 목록을 문자열로 반환한다")
    void returnWinnersAsString() {
        // given
        for(Car car: carRegistry.getCars()){
            car.moveIfPossible();
        }

        // when
        String winners = raceResult.winnersToString();

        // then
        assertThat(winners).contains("최종 우승자 : pobi");
    }

    @Test
    @DisplayName("여러 우승자가 있을 때 우승자를 쉼표로 구분하여 반환한다")
    void returnMultipleWinnersAsString() {
        // given
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("pobi", () -> FORWARD));
        cars.add(new Car("woni", () -> FORWARD));
        carRegistry = new CarRegistry(cars);
        raceResult = new RaceResult(resultBuilder, carRegistry);

        for(Car car: carRegistry.getCars()){
            car.moveIfPossible();
            car.moveIfPossible();
        }

        // when
        String winners = raceResult.winnersToString();

        // then
        assertThat(winners).contains("최종 우승자 : pobi, woni");
    }

    @Test
    @DisplayName("빈 결과 객체를 toString 호출 시 빈 문자열을 반환한다")
    void toStringReturnsEmptyWhenNoResultsAdded() {
        assertThat(raceResult.toString()).isEmpty();
    }
}
