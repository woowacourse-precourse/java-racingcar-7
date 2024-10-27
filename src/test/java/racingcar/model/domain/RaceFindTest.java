package racingcar.model.domain;

import org.junit.jupiter.api.Test;
import racingcar.model.infrastructure.Car;
import racingcar.model.infrastructure.CarMoveDecider;
import racingcar.model.infrastructure.CarRace;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceFindTest {
    @Test
    void 우승자조회테스트() {
        // given
        Decider carMoveDecider = CarMoveDecider.getInstance();
        List<Car> cars = List.of(new Car("name1", 1, carMoveDecider),
                new Car("name2", 2, carMoveDecider),
                new Car("name3", 3, carMoveDecider));
        RaceFind race = new CarRace(1, cars);

        // when
        System.out.println("=====Logic Start=====");

        List<String> winners = race.getWinners();

        System.out.println("=====Logic End=====");
        // then
        assertThat(winners.size()).isOne();
    }
}