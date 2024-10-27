package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarDistance;

public class DistanceTest {

    @Test
    @DisplayName("차의 거리를 테스트한다")
    void create(){
        CarDistance distance = new CarDistance();
        distance.stepForward();
        assertThat(distance.getDistance()).isEqualTo(1);
    }


}
