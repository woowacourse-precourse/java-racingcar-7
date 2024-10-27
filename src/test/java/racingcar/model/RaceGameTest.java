package racingcar.model;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceGameTest {
    @Test
    @DisplayName("RaceGame 객체를 생성할 수 있다.")
    void createRaceGame() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        RaceCars raceCars = new RaceCars(Arrays.asList(car, car2));
        // when
        RaceGame raceGame = new RaceGame(raceCars);
        // then
        Assertions.assertThat(raceGame).isNotNull();
    }

}