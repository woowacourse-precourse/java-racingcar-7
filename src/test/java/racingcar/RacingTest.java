package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FakeGenerator;

class RacingTest {

    private Racing racing;

    @DisplayName("우승자를 정확히 구하는지 확인한다")
    @Test
    void racingTest1() {
        // given
        String carName1 = "car1";
        String carName2 = "car2";
        String carName3 = "car3";
        racing = new Racing(Cars.from(carName1 + "," + carName2 + "," + carName3));
        racing.playRacing(new FakeGenerator(100));

        // when
        List<String> winners = racing.findWinners();

        // then
        Assertions.assertThat(winners.size()).isEqualTo(racing.getCarList().size());
    }

}
