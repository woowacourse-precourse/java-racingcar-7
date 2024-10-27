package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.TryCount;
import racingcar.model.Winner;
import racingcar.util.MoveNumberGenerator;
import racingcar.util.RaceResultStringGenerator;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    @Test
    @DisplayName("경주한 문자열을 잘 반환하는지 테스트")
    void raceStart() {
        //Arrange
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car("car1", new CarNameValidator()),
                new Car("car2", new CarNameValidator())
        ));
        TryCount tryCount = new TryCount(2, new TryCountValidator());
        Race race = new Race(cars, tryCount, new Winner(), new RaceResultStringGenerator());

        //Act
        String resultString = race.startRace(new MoveNumberGenerator() {
            @Override
            public int makeMoveNumber() {
                return 4;
            }
        });

        //Assert
        String expectString = new StringBuilder().append("car1 : ----\n")
                .append("car2 : ----\n\n")
                .append("car1 : --------\n")
                .append("car2 : --------\n\n").toString();
        assertEquals(expectString, resultString);
    }
}
