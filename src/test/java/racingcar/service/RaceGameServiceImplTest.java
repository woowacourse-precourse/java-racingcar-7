package racingcar.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.parser.InputStringParser;
import racingcar.util.parser.StringParser;

public class RaceGameServiceImplTest {

    @Test
    @DisplayName("침가자(자동차)를 등록하는 로직 검증")
    void testEnrollRacer() {
        //given
        RaceGameServiceImpl raceGameService = new RaceGameServiceImpl();
        String racerNames = "pobi,woni,jun";
        StringParser stringParser = new InputStringParser();

        //when
        List<Car> racers = raceGameService.enrollRacer(racerNames, stringParser);
        //then
        assertThat(racers)
                .hasSize(3)
                .extracting(Car::getName)
                .contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("우승자가 한명인 경우 로직 검증")
    public void testFindWinner() {
        RaceGameServiceImpl raceGameService = new RaceGameServiceImpl();

        // given
        Car car1 = new Car("pobi");
        car1.moveFoward();
        car1.moveFoward();

        Car car2 = new Car("woni");
        car2.moveFoward();

        Car car3 = new Car("jun");
        car3.moveFoward();
        car3.moveFoward();
        car3.moveFoward();

        List<Car> cars = List.of(car1, car2, car3);

        // When
        List<Car> winners = raceGameService.findWinner(cars);

        // Then
        assertThat(winners)
                .hasSize(1)
                .extracting(Car::getName)
                .contains("jun");
    }

    @Test
    @DisplayName("우승자가 2명 이상인 경우 로직 검증")
    public void testFindWinnersWhenTie() {
        RaceGameServiceImpl raceGameService = new RaceGameServiceImpl();

        // Given
        Car car1 = new Car("pobi");
        car1.moveFoward();
        car1.moveFoward();

        Car car2 = new Car("woni");
        car2.moveFoward();
        car2.moveFoward();

        List<Car> cars = List.of(car1, car2);

        // When
        List<Car> winners = raceGameService.findWinner(cars);

        // Then
        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .contains("pobi", "woni");
    }
}
