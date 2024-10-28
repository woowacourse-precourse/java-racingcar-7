package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrackTest {

    @Test
    void 매턴_가장_먼거리에_위치한_대상이_승리자이다() {
        //given
        String winnerName = "가솔린차";
        Engine gasoline = new Gasoline(10);
        Vehicle gasolineCar = new Car(winnerName, gasoline);

        Engine randomEngine = new RandomEngine(1, 0, 0);
        Vehicle randomCar = new Car("뽑기차", randomEngine);

        Track track = new Track(List.of(gasolineCar, randomCar));

        //when
        track.runOneCycle();

        //then
        Assertions.assertThat(track.selectWinner()).isEqualTo(winnerName);
    }
}
