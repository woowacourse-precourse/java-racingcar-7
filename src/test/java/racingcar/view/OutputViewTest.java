package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.race.RaceRecord;
import racingcar.domain.race.RaceRoundRecord;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    @Test
    @DisplayName("printRaceRoundResults 테스트")
    void printRaceRoundResultsTest() {
        //given
        Car car1 = new Car("Car1",1);
        Car car2 = new Car("Car2",2);
        Car car3 = new Car("Car3",3);
        Cars cars = new Cars(List.of(car1,car2,car3));
        RaceRecord raceRecord = new RaceRecord(RaceRoundRecord.from(cars));


        car1 = new Car("Car1",2);
        car2 = new Car("Car2",3);
        car3 = new Car("Car3",4);
        cars = new Cars(List.of(car1,car2,car3));

        raceRecord.add(RaceRoundRecord.from(cars));

        outputView.printRaceRoundResults(raceRecord);

    }
}