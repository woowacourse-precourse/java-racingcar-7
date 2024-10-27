package racingcar.model;


import org.junit.jupiter.api.Test;
import racingcar.utils.TestNumberGenerator;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RaceCarsTest {

    @Test
    void 우승자_이름_조회_테스트(){
        List<String> carNames = List.of("car1", "car2", "car3");
        RaceCars raceCars = RaceCars.fromNames(carNames);
        List<String> winnerNames = raceCars.findWinnerNames();

        assertThat(winnerNames).isEqualTo(carNames);
    }

    @Test
    void 레이싱_기능_테스트() {
        RaceCars raceCars = RaceCars.fromNames(List.of("car1", "car2"));
        TestNumberGenerator numberGenerator = new TestNumberGenerator(9);

        raceCars.race(numberGenerator);

        assertThat(raceCars.getCarPositions()).containsExactlyEntriesOf(Map.of("car1", 1, "car2", 1));
    }
}
