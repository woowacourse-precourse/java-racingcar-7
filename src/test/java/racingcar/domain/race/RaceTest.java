package racingcar.domain.race;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.random.DefaultRandomNumberGenerator;

public class RaceTest {

    public static final String USERS = "pobi,kim,kang";

    @Test
    void 게임_생성() {
        // given
        Cars cars = new Cars(USERS);
        Race race = new Race(new DefaultRandomNumberGenerator());

        // when
        race.racing(cars);
    }
}
