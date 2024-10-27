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

    @Test
    @DisplayName("자동차의 distance 가 여러 번 증가하면 증가한다")
    void multipleStepForward(){
        CarDistance distance = new CarDistance();
        distance.stepForward();
        distance.stepForward();
        distance.stepForward();
        assertThat(distance.getDistance()).isEqualTo(3);
    }

}
